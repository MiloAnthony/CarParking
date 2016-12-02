package Car;
public class SeqQueue implements Queue{
	static final int defaultSize=10;
	int front;
	int rear;
	int count;   //元素个数计数器
	int maxSize;
	Object[] data;  //保存队列元素的数组
	
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
			throw new Exception("队列已满!");
		}
		data[rear]=obj;
		rear=(rear+1)%maxSize;  //加1后求模
		count++;
	}
	
	public Object delete() throws Exception{
		if(count==0){
			throw new Exception("队列已空!");
		}
		
		Object temp=data[front];
		front=(front+1)%maxSize;    //加1后求模
		count--;
		return temp;
	}
	
	public Object getFront() throws Exception{
		if(count==0){
			throw new Exception("队列已空!");
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
