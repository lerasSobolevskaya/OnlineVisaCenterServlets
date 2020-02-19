package by.sobol.visacenter.model;

import java.time.LocalDate;

public class SchengenVisa {

	private int id;
	private VisaType visaType;
	private VisaCategory visaCategory;
	private NumberOfEntries numberOfEntries;
	private LocalDate firstDate;
	private LocalDate lastDate;
	private SchengenCountries schengenCountries;
	private VisaStatus visaStatus;
	private CustomerPersonalData customerData;

	public SchengenVisa() {
	}

	public SchengenVisa(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSchengenCountries(SchengenCountries schengenCountries) {
		this.schengenCountries = schengenCountries;
	}

	public VisaStatus getVisaStatus() {
		return visaStatus;
	}

	public void setVisaStatus(VisaStatus visaStatus) {
		this.visaStatus = visaStatus;
	}


	public CustomerPersonalData getCustomerData() {
		return customerData;
	}

	public void setCustomerData(CustomerPersonalData customerData) {
		this.customerData = customerData;
	}

	public VisaType getVisaType() {
		return visaType;
	}

	public void setVisaType(VisaType visaType) {
		this.visaType = visaType;
	}

	public VisaCategory getVisaCategory() {
		return visaCategory;
	}

	public void setVisaCategory(VisaCategory visaCategory) {
		this.visaCategory = visaCategory;
	}

	public NumberOfEntries getNumberOfEntries() {
		return numberOfEntries;
	}

	public void setNumberOfEntries(NumberOfEntries numberOfEntries) {
		this.numberOfEntries = numberOfEntries;
	}

	public LocalDate getFirstDate() {
		return firstDate;
	}

	public void setFirstDate(LocalDate firstDate) {
		this.firstDate = firstDate;
	}

	public LocalDate getLastDate() {
		return lastDate;
	}

	public void setLastDate(LocalDate lastDate) {
		this.lastDate = lastDate;
	}

	public SchengenCountries getSchengenCountries() {
		return schengenCountries;
	}

	public void setSchengenContries(SchengenCountries schengenCountries) {
		this.schengenCountries = schengenCountries;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstDate == null) ? 0 : firstDate.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastDate == null) ? 0 : lastDate.hashCode());
		result = prime * result + ((numberOfEntries == null) ? 0 : numberOfEntries.hashCode());
		result = prime * result + ((schengenCountries == null) ? 0 : schengenCountries.hashCode());
		result = prime * result + ((visaCategory == null) ? 0 : visaCategory.hashCode());
		result = prime * result + ((visaStatus == null) ? 0 : visaStatus.hashCode());
		result = prime * result + ((visaType == null) ? 0 : visaType.hashCode());
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
		SchengenVisa other = (SchengenVisa) obj;
		if (firstDate == null) {
			if (other.firstDate != null)
				return false;
		} else if (!firstDate.equals(other.firstDate))
			return false;
		if (id != other.id)
			return false;
		if (lastDate == null) {
			if (other.lastDate != null)
				return false;
		} else if (!lastDate.equals(other.lastDate))
			return false;
		if (numberOfEntries != other.numberOfEntries)
			return false;
		if (schengenCountries != other.schengenCountries)
			return false;
		if (visaCategory != other.visaCategory)
			return false;
		if (visaStatus != other.visaStatus)
			return false;
		if (visaType != other.visaType)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SchengenVisa [id=" + id + ", visaType=" + visaType + ", visaCategory=" + visaCategory
				+ ", numberOfEntries=" + numberOfEntries + ", firstDate=" + firstDate + ", lastDate=" + lastDate
				+ ", schengenCountries=" + schengenCountries + ", visaStatus=" + visaStatus + "]";
	}

}
