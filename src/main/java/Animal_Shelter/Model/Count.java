package Animal_Shelter.Model;

public class Count implements AutoCloseable {
    private static Integer count = 0;
    private Integer instanceCount;
    private boolean closed = false;


    public void add(String value_1, String value_2) throws Exception{
        if(value_1.isEmpty() || value_2.isEmpty() || this.closed){
            throw new IllegalArgumentException();
        }
        else{
            count++;
            this.instanceCount = count;
        }

    }

    public Integer getCount() {
        return count;
    }

    public Integer getInstanceCount() {
        return instanceCount;
    }


    @Override
    public void close(){
        closed = true;
    }
}
