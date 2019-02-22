假设有N个连续的灯泡，序号为1-N，每次点亮其中一个，如果这个灯泡之前（就是序号比它小）的所有灯泡都已经点亮，那么这个灯泡就会顺便闪一下。
现在给出点亮灯泡的顺序，问中间闪了几次。（可怜我听他口述题目好久才搞懂on和shine不同）
举个栗子：灯泡5个，输入为点亮顺序[5, 1, 3, 2, 4]
第一次点亮5，之前1，2，3，4都不亮，不闪烁；
第二次点亮1，之前没灯，闪烁
第三次点亮3，之前灯2没被点亮，不闪烁
第四次点亮2，之前灯全被点亮，闪烁，
第五次点亮4，之前灯都被点亮，闪烁
答案：3
***************************************************************************
public class light {
        public static void main(String args[]) {
                int[] input = {1,2,3,4};
                int result = shinning(input, input.length);
                System.out.println(result);
        }
        public static int shinning(int[] input, int num) {
                int shine = 0;
                int counter = 0;
                int min = Integer.MAX_VALUE;
                int max = 0;
                
                for(int i = 0; i < input.length; i++){
                        if(min == counter + 1) counter++;
                        if (input == 1) {
                                shine++;
                                counter++;
                        }

                        else if (input == num && i == input.length-1) {
                                shine++;
                        }

                        else{
                                if(counter+1 == input){
                                        shine++;
                                        counter++;
                                }
                                else{
                                        min = (min < input)? min:input;
                                        max = (max > input)? max:input;
                                }
                        }
                        
                        if(max == counter + 1) counter++;
                }
                return shine;
        }
}
