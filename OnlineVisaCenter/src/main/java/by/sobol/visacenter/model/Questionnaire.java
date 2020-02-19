package by.sobol.visacenter.model;

public class Questionnaire {

	private int id;
	private int userId;
	private SchengenVisa visa;
	private QuestionnaireStatus questionnaireStatus;
	private CustomerPersonalData customerData;

	public Questionnaire() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public CustomerPersonalData getCustomerData() {
		return customerData;
	}

	public void setCustomerData(CustomerPersonalData customerData) {
		this.customerData = customerData;
	}

	public SchengenVisa getVisa() {
		return visa;
	}

	public void setVisa(SchengenVisa visa) {
		this.visa = visa;
	}

	public QuestionnaireStatus getQuestionnaireStatus() {
		return questionnaireStatus;
	}

	public void setQuestionnaireStatus(QuestionnaireStatus questionnaireStatus) {
		this.questionnaireStatus = questionnaireStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerData == null) ? 0 : customerData.hashCode());
		result = prime * result + id;
		result = prime * result + ((questionnaireStatus == null) ? 0 : questionnaireStatus.hashCode());
		result = prime * result + userId;
		result = prime * result + ((visa == null) ? 0 : visa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Questionnaire other = (Questionnaire) obj;
		if (customerData == null) {
			if (other.customerData != null)
				return false;
		} else if (!customerData.equals(other.customerData))
			return false;
		if (id != other.id)
			return false;
		if (questionnaireStatus != other.questionnaireStatus)
			return false;
		if (userId != other.userId)
			return false;
		if (visa == null) {
			if (other.visa != null)
				return false;
		} else if (!visa.equals(other.visa))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Questionnaire [id=" + id + ", userId=" + userId + ", visa=" + visa + ", questionnaireStatus="
				+ questionnaireStatus + ", customerData=" + customerData + "]";
	}

}
