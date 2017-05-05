package contracts;

import java.util.List;

public interface Executable {
    String execute(List<String> data) throws Exception;
}
