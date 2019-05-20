package pers.hai.simple.sga;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 标准遗传算法求解函数 编写日期: 2007-12-2
 */
public class SGAFrame extends JFrame {

    private static final long serialVersionUID = 8515517521893874262L;

    private JTextArea textArea;
    private String str = "";
    private Best best = null; // 最佳染色体
    private String[] ipop = new String[10]; // 染色体
    private int gernation = 0; // 染色体代号
    public static final int GENE = 22; // 基因数

    public static void main(String args[]) {
        try {
            SGAFrame frame = new SGAFrame();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the frame
     */
    public SGAFrame() {
        super();

        this.ipop = inialPops();

        getContentPane().setLayout(null);
        setBounds(100, 100, 461, 277);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JLabel label = new JLabel();
        label.setText("X的区间:");
        label.setBounds(23, 10, 88, 15);
        getContentPane().add(label);

        final JLabel label_1 = new JLabel();
        label_1.setText("[-255,255]");
        label_1.setBounds(92, 10, 84, 15);
        getContentPane().add(label_1);

        final JButton calButton = new JButton();
        calButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                SGAFrame s = new SGAFrame();
                str = str + s.process() + "\n";
                textArea.setText(str);
            }
        });
        calButton.setText("求最小值");
        calButton.setBounds(323, 27, 99, 23);
        getContentPane().add(calButton);

        final JLabel label_2 = new JLabel();
        label_2.setText("利用标准遗传算法求解函数f(x)=(x-5)*(x-5)的最小值:");
        label_2.setBounds(23, 31, 318, 15);
        getContentPane().add(label_2);

        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBounds(23, 65, 399, 164);
        getContentPane().add(panel);

        final JScrollPane scrollPane = new JScrollPane();
        panel.add(scrollPane, BorderLayout.CENTER);

        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);
    }

    /**
     * 初始化一条染色体（用二进制字符串表示）
     * 
     * @return 一条染色体
     */
    private String inialPop() {
        String res = "";
        for (int i = 0; i < GENE; i++) {
            if (Math.random() > 0.5) {
                res += "0";
            } else {
                res += "1";
            }
        }
        return res;
    }

    /**
     * 初始化一组染色体
     * 
     * @return 染色体组
     */
    private String[] inialPops() {
        String[] ipop = new String[10];
        for (int i = 0; i < 10; i++) {
            ipop[i] = inialPop();
        }
        return ipop;
    }

    /**
     * 将染色体转换成x的值
     * 
     * @param str
     *            染色体
     * @return 染色体的适应值
     */
    private double calculatefitnessvalue(String str) {
        int b = Integer.parseInt(str, 2);
        double x = -255 + b * (255 - (-255)) / (Math.pow(2, GENE) - 1);
        double fitness = -(x - 5) * (x - 5);
        return fitness;
    }

    /**
     * 计算群体上每个个体的适应度值;
     * 按由个体适应度值所决定的某个规则选择将进入下一代的个体;
     */
    private void select() {
        double evals[] = new double[10]; // 所有染色体适应值
        double p[] = new double[10]; // 各染色体选择概率
        double q[] = new double[10]; // 累计概率
        double F = 0; // 累计适应值总和
        for (int i = 0; i < 10; i++) {
            evals[i] = calculatefitnessvalue(ipop[i]);
            if (best == null) {
                best = new Best();
                best.fitness = evals[i];
                best.generations = 0;
                best.str = ipop[i];
            } else {
                if (evals[i] > best.fitness) // 最好的记录下来
                {
                    best.fitness = evals[i];
                    best.generations = gernation;
                    best.str = ipop[i];
                }
            }
            F = F + evals[i]; // 所有染色体适应值总和

        }
        for (int i = 0; i < 10; i++) {
            p[i] = evals[i] / F;
            if (i == 0)
                q[i] = p[i];
            else {
                q[i] = q[i - 1] + p[i];
            }
        }
        for (int i = 0; i < 10; i++) {

            double r = Math.random();
            if (r <= q[0]) {
                ipop[i] = ipop[0];

            } else {
                for (int j = 1; j < 10; j++) {
                    if (r < q[j]) {
                        ipop[i] = ipop[j];
                        break;
                    }
                }
            }
        }
    }

    /**
     * 交叉操作 交叉率为25%
     * 平均为25%的染色体进行交叉
     */
    private void cross() {
        String temp1, temp2;
        for (int i = 0; i < 10; i++) {
            if (Math.random() < 0.25) {
                double r = Math.random();
                int pos = (int) (Math.round(r * 1000)) % GENE;
                if (pos == 0) {
                    pos = 1;
                }
                temp1 = ipop[i].substring(0, pos)
                        + ipop[(i + 1) % 10].substring(pos);
                temp2 = ipop[(i + 1) % 10].substring(0, pos)
                        + ipop[i].substring(pos);
                ipop[i] = temp1;
                ipop[(i + 1) / 10] = temp2;
            }
        }
    }

    /**
     * 基因突变操作 1%基因变异m*pop_size
     * 共180个基因
     * 为了使每个基因都有相同机会发生变异, 需要产生[1--180]上均匀分布的
     */
    private void mutation() {
        for (int i = 0; i < 4; i++) {
            int num = (int) (Math.random() * GENE * 10 + 1);
            int chromosomeNum = (int) (num / GENE) + 1; // 染色体号

            int mutationNum = num - (chromosomeNum - 1) * GENE; // 基因号
            if (mutationNum == 0) {
                mutationNum = 1;
            }
            chromosomeNum = chromosomeNum - 1;
            if (chromosomeNum >= 10) {
                chromosomeNum = 9;
            }
            String temp;
            if (ipop[chromosomeNum].charAt(mutationNum - 1) == '0') {
                if (mutationNum == 1) {
                    temp = "1" + ipop[chromosomeNum].substring

                    (mutationNum);
                } else {
                    if (mutationNum != GENE) {
                        temp = ipop[chromosomeNum].substring(0, mutationNum -

                        1) + "1" + ipop

                        [chromosomeNum].substring(mutationNum);
                    } else {
                        temp = ipop[chromosomeNum].substring(0, mutationNum - 1)
                                + "1";
                    }
                }
            } else {
                if (mutationNum == 1) {
                    temp = "0" + ipop[chromosomeNum].substring

                    (mutationNum);
                } else {
                    if (mutationNum != GENE) {
                        temp = ipop[chromosomeNum].substring(0, mutationNum -

                        1) + "0" + ipop

                        [chromosomeNum].substring(mutationNum);
                    } else {
                        temp = ipop[chromosomeNum].substring(0, mutationNum - 1)
                                + "1";
                    }
                }
            }
            ipop[chromosomeNum] = temp;
        }
    }

    /**
     * 执行遗传算法
     */
    public String process() {
        String str = "";
        for (int i = 0; i < 10000; i++) {
            this.select();
            this.cross();
            this.mutation();
            gernation = i;
        }
        str = "最小值" + best.fitness + ",第" + best.generations + "个染色体";
        return str;
    }

}
