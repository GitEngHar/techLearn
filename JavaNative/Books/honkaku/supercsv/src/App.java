import java.io.File;
import java.util.Arrays;
import java.util.Map;

import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;


public class App {
    
    public static void main(String[] args) throws Exception {
        LogUtils logu = new LogUtils();
        logu.error(); 
    }
    
    public static void readJson() throws Exception{
        File file = new File("./employee.json");
        ObjectMapper mapper = new ObjectMapper();
        
        Employee emp = mapper.readValue(file,Employee.class);
        System.out.println(emp.getName());
        
        Map<?,?> map = mapper.readValue(file, Map.class);
        System.out.println(map.get("age"));
    }
    public static void createJson() throws Exception{
        Employee emp = new Employee();
        emp.name = "TestUser01";
        emp.licenses = Arrays.asList("CKA","CKS");
        emp.age = 20;

        File file = new File("newEmp.json");
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(file,emp);
    }
}
