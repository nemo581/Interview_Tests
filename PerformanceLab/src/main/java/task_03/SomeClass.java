package task_03;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

public class SomeClass {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<SomeClass> tests;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String title;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String value;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<SomeClass> values;
}
