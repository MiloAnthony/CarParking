package Car;
public class SeqStack implements Stack {
	final int defaultSize=10;
	int top;                //栈顶位置
	Object[] stack;         //数组对象
	int maxStackSize;       //最大数据元素个数
	
	
	public SeqStack(){                     
	        //带造函数
		initiate(defaultSize);
	}
	
	public SeqStack(int sz){                        //带参构造函数
		initiate(sz);
	}
	
	private void initiate(int sz){                    //初始化
		maxStackSize=sz;
		top=0;
		stack=new Object[sz];
	}
	
	public void push(Object obj) throws Exception{     //入栈
		if(top==maxStackSize){
			throw new Exception("堆栈已满!");
		}
		
		stack[top]=obj;                             //保存元素
		top++;                                      //产生新栈顶位置
	}
	
	public Object pop() throws Exception{            //出栈
		if(top==0){
			throw new Exception("堆栈已空!");
		}
		top--;                                        //产生原栈顶位置
		return stack[top];                            //返回原栈顶元素
	}
	
	public Object getTop() throws Exception{           //取栈顶元素
		if(top==0){
			throw new Exception("堆栈已空!");
		}
		return stack[top-1];                          //返回原栈顶元素
	}
	
	public boolean notEmpty(){                         //非空否
		return (top>0);
	}
	public void deleteAll(){
		for(int i=0;i<top;i++){
			stack[i]=null;
		}
	}
}