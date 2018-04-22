import java.io.*;
import java.util.*;

public class Lab35bst
{
    public static ArrayList<Character> operators1 = new ArrayList<>();
    public static void main(String args[])
    {
        ExpressionNode root = ExpressionTree.createTree();

        System.out.println("Original Tree");
        System.out.println("=============");
         System.out.print("\nIn-Fix Notation:    ");
        ExpressionTree.inOrderTraverse(root); ExpressionTree.OutputInorder();
        System.out.print("\n\nPre-Fix Notation:   ");
        ExpressionTree.preOrderTraverse(root); ExpressionTree.OutputPreOrder();
        System.out.print("\n\nPost-Fix Notation:  ");
        ExpressionTree.postOrderTraverse(root); ExpressionTree.OutputPostOrder();
        System.out.println("\n");

        System.out.println("This tree has "+
                ExpressionTree.operatorCount(root)+" operators and "+
                ExpressionTree.numberCount(root)+" numbers, and evaluates to "+
                ExpressionTree.evaluate(root)+"\n\n");
        operators1.add('+'); operators1.add('/'); operators1.add('^'); operators1.add('*'); operators1.add('-');
        ExpressionTree.reset();
		ExpressionNode mirrorRoot = ExpressionTree.mirror(root);
		System.out.println("\nMirror Tree");
		System.out.println("===========");
		System.out.print("\nIn-Fix Notation:    ");
		ExpressionTree.inOrderTraverse(mirrorRoot); ExpressionTree.OutputInorder();
		System.out.print("\n\nPre-Fix Notation:   ");
		ExpressionTree.preOrderTraverse(mirrorRoot); ExpressionTree.OutputPreOrder();
		System.out.print("\n\nPost-Fix Notation:  ");
		ExpressionTree.postOrderTraverse(mirrorRoot); ExpressionTree.OutputPostOrder();
		System.out.println("\n");

		System.out.println("This tree has "+
		    ExpressionTree.operatorCount(mirrorRoot)+" operators and "+
		   	ExpressionTree.numberCount(mirrorRoot)+" numbers, and evaluates to "+
		    ExpressionTree.evaluate(mirrorRoot)+"\n");
    }
}

class ExpressionNode
{
    public ExpressionNode(double initNum, char initOpr, ExpressionNode initLeft, ExpressionNode initRight)
    {
        num = initNum;
        opr = initOpr;
        left = initLeft;
        right = initRight;
    }

    public double getNum()											{ return num; 				}
    public char getOpr()												{ return opr;					}
    public ExpressionNode getLeft()								{ return left; 				}
    public ExpressionNode getRight()							{ return right; 			}
    public void setNum(int theNewNum)							{ num = theNewNum; 		}
    public void setOpr(char theNewOpr)							{ opr = theNewOpr;			}
    public void setLeft(ExpressionNode theNewLeft)		{ left = theNewLeft; 		}
    public void setRight(ExpressionNode theNewRight)	{ right = theNewRight; 	}
    private double num;
    private char opr;
    private ExpressionNode left;
    private ExpressionNode right;
}


class ExpressionTree
{
    public static String outputinorder= "(";
    public static String outputpreorder= "";
    public static String outputpostorder= "";
    public static ArrayList <Character> operands= new ArrayList<Character>();
    public static ExpressionNode createTree()
    {
        ExpressionNode n12  = new ExpressionNode(12,' ',null,null);
        ExpressionNode n6   = new ExpressionNode( 6,' ',null,null);
        ExpressionNode ndiv = new ExpressionNode( 0,'/',n12,n6);
        ExpressionNode n7   = new ExpressionNode( 7,' ',null,null);
        ExpressionNode nadd = new ExpressionNode( 0,'+',n7,ndiv);
        ExpressionNode n2   = new ExpressionNode( 2,' ',null,null);
        ExpressionNode n4   = new ExpressionNode( 4,' ',null,null);
        ExpressionNode ncar = new ExpressionNode( 0,'^',n2,n4);
        ExpressionNode n5   = new ExpressionNode( 5,' ',null,null);
        ExpressionNode nsub = new ExpressionNode( 0,'-',ncar,n5);
        ExpressionNode root = new ExpressionNode( 0,'*',nadd,nsub);
        operands.add('/'); operands.add('*'); operands.add('+'); operands.add('-'); operands.add('^');
        return root;
    }
    public static void OutputInorder(){
        outputinorder = outputinorder.substring(0,outputinorder.indexOf('*')-1)+ ")"+ outputinorder.substring(outputinorder.indexOf('*'),outputinorder.indexOf('*')+1) + "("+ outputinorder.substring(outputinorder.indexOf('*')+1)+")";
        System.out.print(outputinorder);
    }
    public static void OutputPreOrder(){
        System.out.print(outputpreorder);
    }
    public static void OutputPostOrder(){
        System.out.print(outputpostorder);
    }
    public static void reset(){
        outputinorder= "";
        outputpreorder="";
        outputpostorder = "";
    }


    public static void inOrderTraverse (ExpressionNode p)
    {
        if(p!= null){

            inOrderTraverse(p.getLeft());
            //If Opr == ' ' that means this is a leaf to be eval/ parenthesized
            if(p.getOpr()!= ' ') {
                if(p.getRight()!=null && p.getLeft() != null){
                    if(p. getRight().getNum() == 0){
                        if(p.getLeft().getNum()!=0){
                           outputinorder += (" ( " + p.getLeft().getNum() + " " + p.getOpr());

                        }else{
                            outputinorder+=(p.getOpr());

                        }
                    }else if(p.getLeft(). getNum() == 0){
                        outputinorder+=(p.getOpr()  + " " + p.getRight().getNum() + " ) ");
                    }else{
                        outputinorder+=(" ( " + p.getLeft().getNum() + " " + p.getOpr()  + " " + p.getRight().getNum() + " ) ");
                    }
                }

            }
            inOrderTraverse(p.getRight());

        }

    }

    public static void preOrderTraverse (ExpressionNode p)
    {
        if(p!= null){
            if(p.getOpr() == ' '){
                outputpreorder+=( p.getNum()+ " ");
            }else{
                outputpreorder+=(p.getOpr()  + " ");
            }
            preOrderTraverse(p.getLeft());
            preOrderTraverse(p.getRight());
        }
    }

    public static void postOrderTraverse (ExpressionNode p)
    {
        if(p!= null){
            postOrderTraverse(p.getLeft());
            postOrderTraverse(p.getRight());
            if(p.getOpr() == ' '){
                outputpostorder+=(p.getNum()+ " ");
            }else{
                outputpostorder+=(p.getOpr()  + " ");
            }
        }
    }

    public static int numberCount (ExpressionNode p)
    {
        int n= 0;
        Queue <ExpressionNode> q = new LinkedList<>();
        q.add(p);
        while(!q.isEmpty()){
            ExpressionNode item = q.poll();
            if(item.getRight()!=null){
                q.add(item.getRight());
            }
            if(item.getLeft()!=null){
                q.add(item.getLeft());
            }
            if(item.getOpr() == ' '){
                n++;
            }
        }
        return n;
    }

    public static int operatorCount (ExpressionNode p)
    {
        int n= 0;
        Queue <ExpressionNode> q = new LinkedList<>();
        q.add(p);
        while(!q.isEmpty()){
            ExpressionNode item = q.poll();
            if(item.getRight()!=null){
                q.add(item.getRight());
            }
            if(item.getLeft()!=null){
                q.add(item.getLeft());
            }
            if(item.getOpr() != ' '){
                n++;
            }
        }
        return n;
    }

    public static double evaluate (ExpressionNode p)
    {
        Stack<Double> stacks = new Stack<>();
        String arr[] = outputpreorder.split(" ");
        for(int i = arr.length-1; i>=0; i--){
            try{
                stacks.push(Double.parseDouble(arr[i]));
            }catch(Exception e){
            double val1 = stacks.pop(); double val2 = stacks.pop();
            double res ;
            if(arr[i].contains("*")){
                res = val1*val2;
            }else if(arr[i].contains("/")){
                res = val1/val2;
            }else if(arr[i].contains("+")){
                res = val1+val2;
            }else if(arr[i].contains("-")){
                res = val1- val2;
            }else{
                res = Math.pow(val1,val2);
            }
            stacks.push(res);
            }
        }
        return stacks.pop();
    }

    public static ExpressionNode mirror(ExpressionNode p)
	{
        if(p==null){
            return null;
        }else{
            ExpressionNode item= new ExpressionNode(p.getNum(), p.getOpr(), null,null);
            item.setLeft(mirror(p.getRight()));
            item.setRight(mirror(p.getLeft()));
            return item;
        }
	}
}    