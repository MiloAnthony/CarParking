package Car;
public class SeqQueue implements Queue{
	static final int defaultSize=10;
	int front;
	int rear;
	int count;   //Ԫ�ظ���������
	int maxSize;
	Object[] data;  //�������Ԫ�ص�����
	
	public SeqQueue(){
		initiate(defaultSize);
	}
	
	public SeqQueue(int sz){
		initiate(sz);
	}
	
	private void initiate(int sz){
		maxSize=sz;
		front=rear=0;
		count=0;
		data=new Object[sz];
	}
	
	public void append(Object obj) throws Exception{
		if(count>0&&front==rear){
			throw new Exception("��������!");
		}
		data[rear]=obj;
		rear=(rear+1)%maxSize;  //��1����ģ
		count++;
	}
	
	public Object delete() throws Exception{
		if(count==0){
			throw new Exception("�����ѿ�!");
		}
		
		Object temp=data[front];
		front=(front+1)%maxSize;    //��1����ģ
		count--;
		return temp;
	}
	
	public Object getFront() throws Exception{
		if(count==0){
			throw new Exception("�����ѿ�!");
		}
		
		return data[front];
	}
	
	public boolean notEmpty(){
		return count!=0;
	}
	
	public Object getWant(int i){
		return data[i];
	}
	public void deleteAll(){
		for(int i=0;i<count;i++){
			data[i]=null;
		}
	}
	public void setObject(int i,Object s){
		data[i]=s;
		count++;
	}
	public void deleteWant(Object s){
		for(int i=0;i<count;i++){
			if(data[i].equals(s)){
				System.out.println(i);
				count--;
				for(int j=i;j<count;j++){
					data[j]=data[j+1];
				}
			}
		}
	}
}
