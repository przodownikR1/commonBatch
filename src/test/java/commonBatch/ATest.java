package commonBatch;

import static org.mockito.Mockito.doReturn;

import java.util.List;

import junit.framework.Assert;

import org.fest.assertions.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.common.collect.Lists;
@RunWith(MockitoJUnitRunner.class)
public class ATest {
    @Spy 
    private List<String> list = Lists.newArrayList("slawek","borowiec");
 
    @Spy
    private DBAccess dao = new DBAccess();
    
    @Test
    public void spyExample(){
        //given list
        //when
        doReturn("radek").when(list).get(32);
        
        Assertions.assertThat(list.get(32)).isEqualTo("radek");
        
    }
    
    @Test(timeout=1000)
    public void spy2(){
        //doReturn("5").when(dao).countUserInUserTable();
        Assertions.assertThat(dao.countUserInUserTable()).isEqualTo("5");        
        Assertions.assertThat(list.size()).isEqualTo(2);
    }
}
