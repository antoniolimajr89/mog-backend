package br.com.caelum.mog.domains.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.util.Assert;

public class Course {

	@JsonProperty("nome")
    private String name;
	
	@JsonProperty("slug")
    private String code;
	
	@JsonProperty("ementa")
    private List<CourseSummaryItem> summary = new ArrayList<>();

	@JsonProperty("carga_horaria")
	private Integer workload;

	@JsonProperty("requerimentos")
	private Collection<String> prerequisites = new ArrayList<>();

    /**
     * @deprecated frameworks only
     */
    @Deprecated(since = "1.0.0")
    private Course() { }

    public Course(String name, String code, Integer workload , Collection<String> prerequisites, CourseSummaryItem... items) {
        Assert.hasText(name, "Name required");
        Assert.hasText(code, "Code required");
        Assert.notNull(workload, "Workload required");
        Assert.isTrue(workload > 0, "Workload must be positive");
        Assert.notEmpty(items, "Items required");
        Assert.noNullElements(items, "items required");

        this.name = name;
        this.code = code;
        this.workload = workload;
        this.summary = List.of(items);
        this.prerequisites = prerequisites;
    }

    public String getCode() {
        return code;
    }

    public List<CourseSummaryItem> getSummary() {
        return summary;
    }

    public String getName() {
        return name;
    }

    public Integer getWorkload() {
        return workload;
    }

    public Collection<String> getPrerequisites() {
    	return prerequisites;
    }
}
