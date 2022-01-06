package test;

/**
 * 快慢指针结局中间值问题和判断有环无环以及环的入口问题
 */
public class TestQuickSlow {
    //测试类
        public static void main(String[] args) throws Exception {
            Node<String> first = new Node<String>("aa", null);
            Node<String> second = new Node<String>("bb", null);
            Node<String> third = new Node<String>("cc", null);
            Node<String> fourth = new Node<String>("dd", null);
            Node<String> fifth = new Node<String>("ee", null);
            Node<String> six = new Node<String>("ff", null);
            Node<String> seven = new Node<String>("gg", null);
            Node<String> eight = new Node<String>("hh", null);
            Node<String> nine = new Node<String>("II", null);
            //完成结点之间的指向
            first.next = second;
            second.next = third;
            third.next = fourth;
            fourth.next = fifth;
            fifth.next = six;
            six.next = seven;
            seven.next=eight;
            eight.next=nine;
            nine.next=fifth;
            //查找中间值
//            String mid = getMid(first);
//            System.out.println("中间值为："+mid);
            //判断有没有环
//            boolean b = haveCirle(first);
//            System.out.println(b);
//            System.out.println(haveCirle(first) ? "有环":"无环");
            Node enteance = enteance(first);
            System.out.println("该链表中有环的入口元素为"+enteance.item);
        }
        /**
         * @param first 链表的首结点
         * @return 链表的中间结点的值
         */
        public static String getMid(Node<String> first) {
            //定义快慢指针
            Node<String>fast=first;
            Node<String>slow=first;
            while (first!=null && fast.next!=null){
                fast=fast.next.next;
                slow=slow.next;
            }
            return slow.item;

        }
        public static Node enteance(Node<String> first){
            //定义两个指针
            Node<String> fast=first;
            Node<String> slow=first;
            Node<String> temp=null;
            while (fast!=null && fast.next!=null){
                fast=fast.next.next;
                slow=slow.next;
                //当快慢指针相遇，说明有环，定义一个临时指针
                if(fast.equals(slow)){
                    temp=first;
                    continue;
                }
                if(temp!=null){
                    temp=temp.next;
                    //当慢指针和临时指针相遇
                    if(temp.equals(slow)){
                        break;
                    }
                }

            }
           return temp;
        }

    /**
     * 判断是否有环
     * @param first
     * @return
     */
    public static boolean haveCirle(Node<String> first){
            //定义两个指针
            Node<String> fast=first;
            Node<String> slow=first;
            while(first!=null &&first.next!=null){
                fast=fast.next.next;
                slow=slow.next;
                if(fast.equals(slow)){
                    return true;
                }
            }
            return false;
        }
        //结点类
        private static class Node<T> {
            //存储数据
            T item;
            //下一个结点
            Node next;
            public Node(T item, Node next) {
                this.item = item;
                this.next = next;
            }
        }

}
