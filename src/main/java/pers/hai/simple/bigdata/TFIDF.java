package pers.hai.simple.bigdata;

import pers.hai.util.commons.io.FileIO;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * 计算TF-IDF
 * </p>
 * Create Date: 2016年6月17日
 * Last Modify: 2016年6月17日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.0.1
 */
public class TFIDF {

    private final String dataPath = "./data/tfidf";
    
    public static void main(String[] args) {
        new TFIDF().execute();
    }
    
    private void execute() {
        try {
            // 所有的文件数据
            Map<String, List<String>> data  = readData();
            
            // 所有文件中单词的 TF 值 
            Map<String, Map<String, Double>> allTFs = getAllTFs(data);
            System.out.println(allTFs);
            
            // 所有单词的 IDF 值
            Map<String, Double> allIDFs = statisticsIDFs(data);
            System.out.println(allIDFs);
            
            // TF-IDF
            Map<String, Map<String, Double>> allTFIDFs = statisticsTFIDF(allTFs, allIDFs);
            System.out.println(allTFIDFs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private Map<String, List<String>> readData() throws IOException {
        Map<String, List<String>> data = new HashMap<>();
        File[] files = FileIO.listFiles(dataPath);
        for (File file : files) {
            data.put(file.getPath(), FileIO.readLines(file.getPath()));
        }
        return data;
    }
    
    private Map<String, Map<String, Double>> getAllTFs (Map<String, List<String>> data) {
        Map<String, Map<String, Double>> result = new HashMap<>(); // 所有文件中单词的 TF 值 
        
        Set<String> dataKeySet = data.keySet();
        for (String dataKey : dataKeySet) {
            result.put(dataKey, statisticsTF(data.get(dataKey)));
        }
        
        return result;
    }
    
    private Map<String, Double> statisticsTF(List<String> words) {
        Map<String, Double> result = new HashMap<String, Double>();
        
        int totalCount = 0;
        Map<String, Integer> wordCount = new HashMap<String, Integer>();
        
        // word count
        for (String word : words) {
            totalCount++;
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }
        
        // TFs
        Set<String> keySet = wordCount.keySet();
        for (String key : keySet) {
            result.put(key, 1.0 * wordCount.get(key) / totalCount);
        }
        
        return result;
    }
    
    private Map<String, Double> statisticsIDFs (Map<String, List<String>> data) {
        Map<String, Double> result = new HashMap<>();
        int totalFileCount = data.size();
        
        // 统计所有单词被包含在了多个文件中
        Map<String, Integer> allWordsFreq = new HashMap<>();
        Set<String> fileWords = new HashSet<>();
        
        Set<String> dataKeySet = data.keySet();
        for (String dataKey : dataKeySet) {
            fileWords = new HashSet<>();
            fileWords.addAll(data.get(dataKey));
            for (String word : fileWords) {
                if (allWordsFreq.containsKey(word)) {
                    allWordsFreq.put(word, allWordsFreq.get(word) + 1);
                } else {
                    allWordsFreq.put(word, 1);
                }
            }
            fileWords.clear();
        }
        
        // 统计所有单词的 IDF
        Set<String> allWordsFreqKeySet = allWordsFreq.keySet();
        for (String key : allWordsFreqKeySet) {
            result.put(key, Math.log10(1.0 * totalFileCount / (allWordsFreq.get(key) + 1)));
        }
        
        return result;
    }
    
    private Map<String, Map<String, Double>> statisticsTFIDF(Map<String, Map<String, Double>> allTFs, Map<String, Double> allIDFs) {
        Map<String, Map<String, Double>> result = new HashMap<>();
        
        Set<String> allTFKeys = allTFs.keySet();
        Map<String, Double> oneFileTFs = null;
        for (String fileName : allTFKeys) {
            oneFileTFs = allTFs.get(fileName);
            Set<String> oneFileTfKeys = oneFileTFs.keySet();
            for (String word : oneFileTfKeys) {
                double tfidf = oneFileTFs.get(word) * allIDFs.get(word);
                if (result.containsKey(fileName)) {
                    Map<String, Double> singleWordTfidf = result.get(fileName);
                    singleWordTfidf.put(word, tfidf);
                } else {
                    Map<String, Double> singleWordTfidf = new HashMap<>();
                    singleWordTfidf.put(word, tfidf);
                    result.put(fileName, singleWordTfidf);
                }
            }
        }
        
        return result;
    }
}
