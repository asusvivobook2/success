package in.ajay.bindings;

import lombok.Data;

@Data
public class PlanResponse {

	private Integer planId;

	private String planName;

	private String holderName;

	private long holderSsn;

	private String planStatus;

}
