package Car;
public class SeqStack implements Stack {
	final int defaultSize=10;
	int top;                //ջ��λ��
	Object[] stack;         //�������
	int maxStackSize;       //�������Ԫ�ظ���
	
	
	public SeqStack(){                     
	        //���캯��
		initiate(defaultSize);
	}
	
	public SeqStack(int sz){                        //���ι��캯��
		initiate(sz);
	}
	
	private void initiate(int sz){                    //��ʼ��
		maxStackSize=sz;
		top=0;
		stack=new Object[sz];
	}
	
	public void push(Object obj) throws Exception{     //��ջ
		if(top==maxStackSize){
			throw new Exception("��ջ����!");
		}
		
		stack[top]=obj;                             //����Ԫ��
		top++;                                      //������ջ��λ��
	}
	
	public Object pop() throws Exception{            //��ջ
		if(top==0){
			throw new Exception("��ջ�ѿ�!");
		}
		top--;                                        //����ԭջ��λ��
		return stack[top];                            //����ԭջ��Ԫ��
	}
	
	public Object getTop() throws Exception{           //ȡջ��Ԫ��
		if(top==0){
			throw new Exception("��ջ�ѿ�!");
		}
		return stack[top-1];                          //����ԭջ��Ԫ��
	}
	
	public boolean notEmpty(){                         //�ǿշ�
		return (top>0);
	}
	public void deleteAll(){
		for(int i=0;i<top;i++){
			stack[i]=null;
		}
	}
}