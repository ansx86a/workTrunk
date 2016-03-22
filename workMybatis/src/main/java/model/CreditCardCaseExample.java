package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CreditCardCaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CreditCardCaseExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andCaseNoIsNull() {
            addCriterion("case_no is null");
            return (Criteria) this;
        }

        public Criteria andCaseNoIsNotNull() {
            addCriterion("case_no is not null");
            return (Criteria) this;
        }

        public Criteria andCaseNoEqualTo(String value) {
            addCriterion("case_no =", value, "caseNo");
            return (Criteria) this;
        }

        public Criteria andCaseNoNotEqualTo(String value) {
            addCriterion("case_no <>", value, "caseNo");
            return (Criteria) this;
        }

        public Criteria andCaseNoGreaterThan(String value) {
            addCriterion("case_no >", value, "caseNo");
            return (Criteria) this;
        }

        public Criteria andCaseNoGreaterThanOrEqualTo(String value) {
            addCriterion("case_no >=", value, "caseNo");
            return (Criteria) this;
        }

        public Criteria andCaseNoLessThan(String value) {
            addCriterion("case_no <", value, "caseNo");
            return (Criteria) this;
        }

        public Criteria andCaseNoLessThanOrEqualTo(String value) {
            addCriterion("case_no <=", value, "caseNo");
            return (Criteria) this;
        }

        public Criteria andCaseNoLike(String value) {
            addCriterion("case_no like", value, "caseNo");
            return (Criteria) this;
        }

        public Criteria andCaseNoNotLike(String value) {
            addCriterion("case_no not like", value, "caseNo");
            return (Criteria) this;
        }

        public Criteria andCaseNoIn(List<String> values) {
            addCriterion("case_no in", values, "caseNo");
            return (Criteria) this;
        }

        public Criteria andCaseNoNotIn(List<String> values) {
            addCriterion("case_no not in", values, "caseNo");
            return (Criteria) this;
        }

        public Criteria andCaseNoBetween(String value1, String value2) {
            addCriterion("case_no between", value1, value2, "caseNo");
            return (Criteria) this;
        }

        public Criteria andCaseNoNotBetween(String value1, String value2) {
            addCriterion("case_no not between", value1, value2, "caseNo");
            return (Criteria) this;
        }

        public Criteria andCaseCreationDateIsNull() {
            addCriterion("case_creation_date is null");
            return (Criteria) this;
        }

        public Criteria andCaseCreationDateIsNotNull() {
            addCriterion("case_creation_date is not null");
            return (Criteria) this;
        }

        public Criteria andCaseCreationDateEqualTo(Date value) {
            addCriterion("case_creation_date =", value, "caseCreationDate");
            return (Criteria) this;
        }

        public Criteria andCaseCreationDateNotEqualTo(Date value) {
            addCriterion("case_creation_date <>", value, "caseCreationDate");
            return (Criteria) this;
        }

        public Criteria andCaseCreationDateGreaterThan(Date value) {
            addCriterion("case_creation_date >", value, "caseCreationDate");
            return (Criteria) this;
        }

        public Criteria andCaseCreationDateGreaterThanOrEqualTo(Date value) {
            addCriterion("case_creation_date >=", value, "caseCreationDate");
            return (Criteria) this;
        }

        public Criteria andCaseCreationDateLessThan(Date value) {
            addCriterion("case_creation_date <", value, "caseCreationDate");
            return (Criteria) this;
        }

        public Criteria andCaseCreationDateLessThanOrEqualTo(Date value) {
            addCriterion("case_creation_date <=", value, "caseCreationDate");
            return (Criteria) this;
        }

        public Criteria andCaseCreationDateIn(List<Date> values) {
            addCriterion("case_creation_date in", values, "caseCreationDate");
            return (Criteria) this;
        }

        public Criteria andCaseCreationDateNotIn(List<Date> values) {
            addCriterion("case_creation_date not in", values, "caseCreationDate");
            return (Criteria) this;
        }

        public Criteria andCaseCreationDateBetween(Date value1, Date value2) {
            addCriterion("case_creation_date between", value1, value2, "caseCreationDate");
            return (Criteria) this;
        }

        public Criteria andCaseCreationDateNotBetween(Date value1, Date value2) {
            addCriterion("case_creation_date not between", value1, value2, "caseCreationDate");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("ip is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("ip is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("ip =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("ip <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("ip >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("ip >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("ip <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("ip <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("ip like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("ip not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("ip in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("ip not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("ip between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("ip not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andCampaignCodeIsNull() {
            addCriterion("campaign_code is null");
            return (Criteria) this;
        }

        public Criteria andCampaignCodeIsNotNull() {
            addCriterion("campaign_code is not null");
            return (Criteria) this;
        }

        public Criteria andCampaignCodeEqualTo(String value) {
            addCriterion("campaign_code =", value, "campaignCode");
            return (Criteria) this;
        }

        public Criteria andCampaignCodeNotEqualTo(String value) {
            addCriterion("campaign_code <>", value, "campaignCode");
            return (Criteria) this;
        }

        public Criteria andCampaignCodeGreaterThan(String value) {
            addCriterion("campaign_code >", value, "campaignCode");
            return (Criteria) this;
        }

        public Criteria andCampaignCodeGreaterThanOrEqualTo(String value) {
            addCriterion("campaign_code >=", value, "campaignCode");
            return (Criteria) this;
        }

        public Criteria andCampaignCodeLessThan(String value) {
            addCriterion("campaign_code <", value, "campaignCode");
            return (Criteria) this;
        }

        public Criteria andCampaignCodeLessThanOrEqualTo(String value) {
            addCriterion("campaign_code <=", value, "campaignCode");
            return (Criteria) this;
        }

        public Criteria andCampaignCodeLike(String value) {
            addCriterion("campaign_code like", value, "campaignCode");
            return (Criteria) this;
        }

        public Criteria andCampaignCodeNotLike(String value) {
            addCriterion("campaign_code not like", value, "campaignCode");
            return (Criteria) this;
        }

        public Criteria andCampaignCodeIn(List<String> values) {
            addCriterion("campaign_code in", values, "campaignCode");
            return (Criteria) this;
        }

        public Criteria andCampaignCodeNotIn(List<String> values) {
            addCriterion("campaign_code not in", values, "campaignCode");
            return (Criteria) this;
        }

        public Criteria andCampaignCodeBetween(String value1, String value2) {
            addCriterion("campaign_code between", value1, value2, "campaignCode");
            return (Criteria) this;
        }

        public Criteria andCampaignCodeNotBetween(String value1, String value2) {
            addCriterion("campaign_code not between", value1, value2, "campaignCode");
            return (Criteria) this;
        }

        public Criteria andCardNameIsNull() {
            addCriterion("card_name is null");
            return (Criteria) this;
        }

        public Criteria andCardNameIsNotNull() {
            addCriterion("card_name is not null");
            return (Criteria) this;
        }

        public Criteria andCardNameEqualTo(Integer value) {
            addCriterion("card_name =", value, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameNotEqualTo(Integer value) {
            addCriterion("card_name <>", value, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameGreaterThan(Integer value) {
            addCriterion("card_name >", value, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameGreaterThanOrEqualTo(Integer value) {
            addCriterion("card_name >=", value, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameLessThan(Integer value) {
            addCriterion("card_name <", value, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameLessThanOrEqualTo(Integer value) {
            addCriterion("card_name <=", value, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameIn(List<Integer> values) {
            addCriterion("card_name in", values, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameNotIn(List<Integer> values) {
            addCriterion("card_name not in", values, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameBetween(Integer value1, Integer value2) {
            addCriterion("card_name between", value1, value2, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameNotBetween(Integer value1, Integer value2) {
            addCriterion("card_name not between", value1, value2, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardTypeIsNull() {
            addCriterion("card_type is null");
            return (Criteria) this;
        }

        public Criteria andCardTypeIsNotNull() {
            addCriterion("card_type is not null");
            return (Criteria) this;
        }

        public Criteria andCardTypeEqualTo(Integer value) {
            addCriterion("card_type =", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotEqualTo(Integer value) {
            addCriterion("card_type <>", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeGreaterThan(Integer value) {
            addCriterion("card_type >", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("card_type >=", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLessThan(Integer value) {
            addCriterion("card_type <", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLessThanOrEqualTo(Integer value) {
            addCriterion("card_type <=", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeIn(List<Integer> values) {
            addCriterion("card_type in", values, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotIn(List<Integer> values) {
            addCriterion("card_type not in", values, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeBetween(Integer value1, Integer value2) {
            addCriterion("card_type between", value1, value2, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("card_type not between", value1, value2, "cardType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeIsNull() {
            addCriterion("case_type is null");
            return (Criteria) this;
        }

        public Criteria andCaseTypeIsNotNull() {
            addCriterion("case_type is not null");
            return (Criteria) this;
        }

        public Criteria andCaseTypeEqualTo(Integer value) {
            addCriterion("case_type =", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeNotEqualTo(Integer value) {
            addCriterion("case_type <>", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeGreaterThan(Integer value) {
            addCriterion("case_type >", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("case_type >=", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeLessThan(Integer value) {
            addCriterion("case_type <", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeLessThanOrEqualTo(Integer value) {
            addCriterion("case_type <=", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeIn(List<Integer> values) {
            addCriterion("case_type in", values, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeNotIn(List<Integer> values) {
            addCriterion("case_type not in", values, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeBetween(Integer value1, Integer value2) {
            addCriterion("case_type between", value1, value2, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("case_type not between", value1, value2, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseApplyTypeIsNull() {
            addCriterion("case_apply_type is null");
            return (Criteria) this;
        }

        public Criteria andCaseApplyTypeIsNotNull() {
            addCriterion("case_apply_type is not null");
            return (Criteria) this;
        }

        public Criteria andCaseApplyTypeEqualTo(Integer value) {
            addCriterion("case_apply_type =", value, "caseApplyType");
            return (Criteria) this;
        }

        public Criteria andCaseApplyTypeNotEqualTo(Integer value) {
            addCriterion("case_apply_type <>", value, "caseApplyType");
            return (Criteria) this;
        }

        public Criteria andCaseApplyTypeGreaterThan(Integer value) {
            addCriterion("case_apply_type >", value, "caseApplyType");
            return (Criteria) this;
        }

        public Criteria andCaseApplyTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("case_apply_type >=", value, "caseApplyType");
            return (Criteria) this;
        }

        public Criteria andCaseApplyTypeLessThan(Integer value) {
            addCriterion("case_apply_type <", value, "caseApplyType");
            return (Criteria) this;
        }

        public Criteria andCaseApplyTypeLessThanOrEqualTo(Integer value) {
            addCriterion("case_apply_type <=", value, "caseApplyType");
            return (Criteria) this;
        }

        public Criteria andCaseApplyTypeIn(List<Integer> values) {
            addCriterion("case_apply_type in", values, "caseApplyType");
            return (Criteria) this;
        }

        public Criteria andCaseApplyTypeNotIn(List<Integer> values) {
            addCriterion("case_apply_type not in", values, "caseApplyType");
            return (Criteria) this;
        }

        public Criteria andCaseApplyTypeBetween(Integer value1, Integer value2) {
            addCriterion("case_apply_type between", value1, value2, "caseApplyType");
            return (Criteria) this;
        }

        public Criteria andCaseApplyTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("case_apply_type not between", value1, value2, "caseApplyType");
            return (Criteria) this;
        }

        public Criteria andIdcardIssueDateIsNull() {
            addCriterion("idcard_issue_date is null");
            return (Criteria) this;
        }

        public Criteria andIdcardIssueDateIsNotNull() {
            addCriterion("idcard_issue_date is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardIssueDateEqualTo(Date value) {
            addCriterion("idcard_issue_date =", value, "idcardIssueDate");
            return (Criteria) this;
        }

        public Criteria andIdcardIssueDateNotEqualTo(Date value) {
            addCriterion("idcard_issue_date <>", value, "idcardIssueDate");
            return (Criteria) this;
        }

        public Criteria andIdcardIssueDateGreaterThan(Date value) {
            addCriterion("idcard_issue_date >", value, "idcardIssueDate");
            return (Criteria) this;
        }

        public Criteria andIdcardIssueDateGreaterThanOrEqualTo(Date value) {
            addCriterion("idcard_issue_date >=", value, "idcardIssueDate");
            return (Criteria) this;
        }

        public Criteria andIdcardIssueDateLessThan(Date value) {
            addCriterion("idcard_issue_date <", value, "idcardIssueDate");
            return (Criteria) this;
        }

        public Criteria andIdcardIssueDateLessThanOrEqualTo(Date value) {
            addCriterion("idcard_issue_date <=", value, "idcardIssueDate");
            return (Criteria) this;
        }

        public Criteria andIdcardIssueDateIn(List<Date> values) {
            addCriterion("idcard_issue_date in", values, "idcardIssueDate");
            return (Criteria) this;
        }

        public Criteria andIdcardIssueDateNotIn(List<Date> values) {
            addCriterion("idcard_issue_date not in", values, "idcardIssueDate");
            return (Criteria) this;
        }

        public Criteria andIdcardIssueDateBetween(Date value1, Date value2) {
            addCriterion("idcard_issue_date between", value1, value2, "idcardIssueDate");
            return (Criteria) this;
        }

        public Criteria andIdcardIssueDateNotBetween(Date value1, Date value2) {
            addCriterion("idcard_issue_date not between", value1, value2, "idcardIssueDate");
            return (Criteria) this;
        }

        public Criteria andIdcardIssueStatusIsNull() {
            addCriterion("idcard_issue_status is null");
            return (Criteria) this;
        }

        public Criteria andIdcardIssueStatusIsNotNull() {
            addCriterion("idcard_issue_status is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardIssueStatusEqualTo(Integer value) {
            addCriterion("idcard_issue_status =", value, "idcardIssueStatus");
            return (Criteria) this;
        }

        public Criteria andIdcardIssueStatusNotEqualTo(Integer value) {
            addCriterion("idcard_issue_status <>", value, "idcardIssueStatus");
            return (Criteria) this;
        }

        public Criteria andIdcardIssueStatusGreaterThan(Integer value) {
            addCriterion("idcard_issue_status >", value, "idcardIssueStatus");
            return (Criteria) this;
        }

        public Criteria andIdcardIssueStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("idcard_issue_status >=", value, "idcardIssueStatus");
            return (Criteria) this;
        }

        public Criteria andIdcardIssueStatusLessThan(Integer value) {
            addCriterion("idcard_issue_status <", value, "idcardIssueStatus");
            return (Criteria) this;
        }

        public Criteria andIdcardIssueStatusLessThanOrEqualTo(Integer value) {
            addCriterion("idcard_issue_status <=", value, "idcardIssueStatus");
            return (Criteria) this;
        }

        public Criteria andIdcardIssueStatusIn(List<Integer> values) {
            addCriterion("idcard_issue_status in", values, "idcardIssueStatus");
            return (Criteria) this;
        }

        public Criteria andIdcardIssueStatusNotIn(List<Integer> values) {
            addCriterion("idcard_issue_status not in", values, "idcardIssueStatus");
            return (Criteria) this;
        }

        public Criteria andIdcardIssueStatusBetween(Integer value1, Integer value2) {
            addCriterion("idcard_issue_status between", value1, value2, "idcardIssueStatus");
            return (Criteria) this;
        }

        public Criteria andIdcardIssueStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("idcard_issue_status not between", value1, value2, "idcardIssueStatus");
            return (Criteria) this;
        }

        public Criteria andPersonCnNameIsNull() {
            addCriterion("person_cn_name is null");
            return (Criteria) this;
        }

        public Criteria andPersonCnNameIsNotNull() {
            addCriterion("person_cn_name is not null");
            return (Criteria) this;
        }

        public Criteria andPersonCnNameEqualTo(String value) {
            addCriterion("person_cn_name =", value, "personCnName");
            return (Criteria) this;
        }

        public Criteria andPersonCnNameNotEqualTo(String value) {
            addCriterion("person_cn_name <>", value, "personCnName");
            return (Criteria) this;
        }

        public Criteria andPersonCnNameGreaterThan(String value) {
            addCriterion("person_cn_name >", value, "personCnName");
            return (Criteria) this;
        }

        public Criteria andPersonCnNameGreaterThanOrEqualTo(String value) {
            addCriterion("person_cn_name >=", value, "personCnName");
            return (Criteria) this;
        }

        public Criteria andPersonCnNameLessThan(String value) {
            addCriterion("person_cn_name <", value, "personCnName");
            return (Criteria) this;
        }

        public Criteria andPersonCnNameLessThanOrEqualTo(String value) {
            addCriterion("person_cn_name <=", value, "personCnName");
            return (Criteria) this;
        }

        public Criteria andPersonCnNameLike(String value) {
            addCriterion("person_cn_name like", value, "personCnName");
            return (Criteria) this;
        }

        public Criteria andPersonCnNameNotLike(String value) {
            addCriterion("person_cn_name not like", value, "personCnName");
            return (Criteria) this;
        }

        public Criteria andPersonCnNameIn(List<String> values) {
            addCriterion("person_cn_name in", values, "personCnName");
            return (Criteria) this;
        }

        public Criteria andPersonCnNameNotIn(List<String> values) {
            addCriterion("person_cn_name not in", values, "personCnName");
            return (Criteria) this;
        }

        public Criteria andPersonCnNameBetween(String value1, String value2) {
            addCriterion("person_cn_name between", value1, value2, "personCnName");
            return (Criteria) this;
        }

        public Criteria andPersonCnNameNotBetween(String value1, String value2) {
            addCriterion("person_cn_name not between", value1, value2, "personCnName");
            return (Criteria) this;
        }

        public Criteria andPersonIdIsNull() {
            addCriterion("person_id is null");
            return (Criteria) this;
        }

        public Criteria andPersonIdIsNotNull() {
            addCriterion("person_id is not null");
            return (Criteria) this;
        }

        public Criteria andPersonIdEqualTo(String value) {
            addCriterion("person_id =", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdNotEqualTo(String value) {
            addCriterion("person_id <>", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdGreaterThan(String value) {
            addCriterion("person_id >", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdGreaterThanOrEqualTo(String value) {
            addCriterion("person_id >=", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdLessThan(String value) {
            addCriterion("person_id <", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdLessThanOrEqualTo(String value) {
            addCriterion("person_id <=", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdLike(String value) {
            addCriterion("person_id like", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdNotLike(String value) {
            addCriterion("person_id not like", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdIn(List<String> values) {
            addCriterion("person_id in", values, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdNotIn(List<String> values) {
            addCriterion("person_id not in", values, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdBetween(String value1, String value2) {
            addCriterion("person_id between", value1, value2, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdNotBetween(String value1, String value2) {
            addCriterion("person_id not between", value1, value2, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonBirthdayIsNull() {
            addCriterion("person_birthday is null");
            return (Criteria) this;
        }

        public Criteria andPersonBirthdayIsNotNull() {
            addCriterion("person_birthday is not null");
            return (Criteria) this;
        }

        public Criteria andPersonBirthdayEqualTo(Date value) {
            addCriterion("person_birthday =", value, "personBirthday");
            return (Criteria) this;
        }

        public Criteria andPersonBirthdayNotEqualTo(Date value) {
            addCriterion("person_birthday <>", value, "personBirthday");
            return (Criteria) this;
        }

        public Criteria andPersonBirthdayGreaterThan(Date value) {
            addCriterion("person_birthday >", value, "personBirthday");
            return (Criteria) this;
        }

        public Criteria andPersonBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterion("person_birthday >=", value, "personBirthday");
            return (Criteria) this;
        }

        public Criteria andPersonBirthdayLessThan(Date value) {
            addCriterion("person_birthday <", value, "personBirthday");
            return (Criteria) this;
        }

        public Criteria andPersonBirthdayLessThanOrEqualTo(Date value) {
            addCriterion("person_birthday <=", value, "personBirthday");
            return (Criteria) this;
        }

        public Criteria andPersonBirthdayIn(List<Date> values) {
            addCriterion("person_birthday in", values, "personBirthday");
            return (Criteria) this;
        }

        public Criteria andPersonBirthdayNotIn(List<Date> values) {
            addCriterion("person_birthday not in", values, "personBirthday");
            return (Criteria) this;
        }

        public Criteria andPersonBirthdayBetween(Date value1, Date value2) {
            addCriterion("person_birthday between", value1, value2, "personBirthday");
            return (Criteria) this;
        }

        public Criteria andPersonBirthdayNotBetween(Date value1, Date value2) {
            addCriterion("person_birthday not between", value1, value2, "personBirthday");
            return (Criteria) this;
        }

        public Criteria andPersonHomePhoneIsNull() {
            addCriterion("person_home_phone is null");
            return (Criteria) this;
        }

        public Criteria andPersonHomePhoneIsNotNull() {
            addCriterion("person_home_phone is not null");
            return (Criteria) this;
        }

        public Criteria andPersonHomePhoneEqualTo(String value) {
            addCriterion("person_home_phone =", value, "personHomePhone");
            return (Criteria) this;
        }

        public Criteria andPersonHomePhoneNotEqualTo(String value) {
            addCriterion("person_home_phone <>", value, "personHomePhone");
            return (Criteria) this;
        }

        public Criteria andPersonHomePhoneGreaterThan(String value) {
            addCriterion("person_home_phone >", value, "personHomePhone");
            return (Criteria) this;
        }

        public Criteria andPersonHomePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("person_home_phone >=", value, "personHomePhone");
            return (Criteria) this;
        }

        public Criteria andPersonHomePhoneLessThan(String value) {
            addCriterion("person_home_phone <", value, "personHomePhone");
            return (Criteria) this;
        }

        public Criteria andPersonHomePhoneLessThanOrEqualTo(String value) {
            addCriterion("person_home_phone <=", value, "personHomePhone");
            return (Criteria) this;
        }

        public Criteria andPersonHomePhoneLike(String value) {
            addCriterion("person_home_phone like", value, "personHomePhone");
            return (Criteria) this;
        }

        public Criteria andPersonHomePhoneNotLike(String value) {
            addCriterion("person_home_phone not like", value, "personHomePhone");
            return (Criteria) this;
        }

        public Criteria andPersonHomePhoneIn(List<String> values) {
            addCriterion("person_home_phone in", values, "personHomePhone");
            return (Criteria) this;
        }

        public Criteria andPersonHomePhoneNotIn(List<String> values) {
            addCriterion("person_home_phone not in", values, "personHomePhone");
            return (Criteria) this;
        }

        public Criteria andPersonHomePhoneBetween(String value1, String value2) {
            addCriterion("person_home_phone between", value1, value2, "personHomePhone");
            return (Criteria) this;
        }

        public Criteria andPersonHomePhoneNotBetween(String value1, String value2) {
            addCriterion("person_home_phone not between", value1, value2, "personHomePhone");
            return (Criteria) this;
        }

        public Criteria andPersonMobileIsNull() {
            addCriterion("person_mobile is null");
            return (Criteria) this;
        }

        public Criteria andPersonMobileIsNotNull() {
            addCriterion("person_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andPersonMobileEqualTo(String value) {
            addCriterion("person_mobile =", value, "personMobile");
            return (Criteria) this;
        }

        public Criteria andPersonMobileNotEqualTo(String value) {
            addCriterion("person_mobile <>", value, "personMobile");
            return (Criteria) this;
        }

        public Criteria andPersonMobileGreaterThan(String value) {
            addCriterion("person_mobile >", value, "personMobile");
            return (Criteria) this;
        }

        public Criteria andPersonMobileGreaterThanOrEqualTo(String value) {
            addCriterion("person_mobile >=", value, "personMobile");
            return (Criteria) this;
        }

        public Criteria andPersonMobileLessThan(String value) {
            addCriterion("person_mobile <", value, "personMobile");
            return (Criteria) this;
        }

        public Criteria andPersonMobileLessThanOrEqualTo(String value) {
            addCriterion("person_mobile <=", value, "personMobile");
            return (Criteria) this;
        }

        public Criteria andPersonMobileLike(String value) {
            addCriterion("person_mobile like", value, "personMobile");
            return (Criteria) this;
        }

        public Criteria andPersonMobileNotLike(String value) {
            addCriterion("person_mobile not like", value, "personMobile");
            return (Criteria) this;
        }

        public Criteria andPersonMobileIn(List<String> values) {
            addCriterion("person_mobile in", values, "personMobile");
            return (Criteria) this;
        }

        public Criteria andPersonMobileNotIn(List<String> values) {
            addCriterion("person_mobile not in", values, "personMobile");
            return (Criteria) this;
        }

        public Criteria andPersonMobileBetween(String value1, String value2) {
            addCriterion("person_mobile between", value1, value2, "personMobile");
            return (Criteria) this;
        }

        public Criteria andPersonMobileNotBetween(String value1, String value2) {
            addCriterion("person_mobile not between", value1, value2, "personMobile");
            return (Criteria) this;
        }

        public Criteria andPersonEmailIsNull() {
            addCriterion("person_email is null");
            return (Criteria) this;
        }

        public Criteria andPersonEmailIsNotNull() {
            addCriterion("person_email is not null");
            return (Criteria) this;
        }

        public Criteria andPersonEmailEqualTo(String value) {
            addCriterion("person_email =", value, "personEmail");
            return (Criteria) this;
        }

        public Criteria andPersonEmailNotEqualTo(String value) {
            addCriterion("person_email <>", value, "personEmail");
            return (Criteria) this;
        }

        public Criteria andPersonEmailGreaterThan(String value) {
            addCriterion("person_email >", value, "personEmail");
            return (Criteria) this;
        }

        public Criteria andPersonEmailGreaterThanOrEqualTo(String value) {
            addCriterion("person_email >=", value, "personEmail");
            return (Criteria) this;
        }

        public Criteria andPersonEmailLessThan(String value) {
            addCriterion("person_email <", value, "personEmail");
            return (Criteria) this;
        }

        public Criteria andPersonEmailLessThanOrEqualTo(String value) {
            addCriterion("person_email <=", value, "personEmail");
            return (Criteria) this;
        }

        public Criteria andPersonEmailLike(String value) {
            addCriterion("person_email like", value, "personEmail");
            return (Criteria) this;
        }

        public Criteria andPersonEmailNotLike(String value) {
            addCriterion("person_email not like", value, "personEmail");
            return (Criteria) this;
        }

        public Criteria andPersonEmailIn(List<String> values) {
            addCriterion("person_email in", values, "personEmail");
            return (Criteria) this;
        }

        public Criteria andPersonEmailNotIn(List<String> values) {
            addCriterion("person_email not in", values, "personEmail");
            return (Criteria) this;
        }

        public Criteria andPersonEmailBetween(String value1, String value2) {
            addCriterion("person_email between", value1, value2, "personEmail");
            return (Criteria) this;
        }

        public Criteria andPersonEmailNotBetween(String value1, String value2) {
            addCriterion("person_email not between", value1, value2, "personEmail");
            return (Criteria) this;
        }

        public Criteria andPersonMarriageIsNull() {
            addCriterion("person_marriage is null");
            return (Criteria) this;
        }

        public Criteria andPersonMarriageIsNotNull() {
            addCriterion("person_marriage is not null");
            return (Criteria) this;
        }

        public Criteria andPersonMarriageEqualTo(Integer value) {
            addCriterion("person_marriage =", value, "personMarriage");
            return (Criteria) this;
        }

        public Criteria andPersonMarriageNotEqualTo(Integer value) {
            addCriterion("person_marriage <>", value, "personMarriage");
            return (Criteria) this;
        }

        public Criteria andPersonMarriageGreaterThan(Integer value) {
            addCriterion("person_marriage >", value, "personMarriage");
            return (Criteria) this;
        }

        public Criteria andPersonMarriageGreaterThanOrEqualTo(Integer value) {
            addCriterion("person_marriage >=", value, "personMarriage");
            return (Criteria) this;
        }

        public Criteria andPersonMarriageLessThan(Integer value) {
            addCriterion("person_marriage <", value, "personMarriage");
            return (Criteria) this;
        }

        public Criteria andPersonMarriageLessThanOrEqualTo(Integer value) {
            addCriterion("person_marriage <=", value, "personMarriage");
            return (Criteria) this;
        }

        public Criteria andPersonMarriageIn(List<Integer> values) {
            addCriterion("person_marriage in", values, "personMarriage");
            return (Criteria) this;
        }

        public Criteria andPersonMarriageNotIn(List<Integer> values) {
            addCriterion("person_marriage not in", values, "personMarriage");
            return (Criteria) this;
        }

        public Criteria andPersonMarriageBetween(Integer value1, Integer value2) {
            addCriterion("person_marriage between", value1, value2, "personMarriage");
            return (Criteria) this;
        }

        public Criteria andPersonMarriageNotBetween(Integer value1, Integer value2) {
            addCriterion("person_marriage not between", value1, value2, "personMarriage");
            return (Criteria) this;
        }

        public Criteria andPersonEnNameIsNull() {
            addCriterion("person_en_name is null");
            return (Criteria) this;
        }

        public Criteria andPersonEnNameIsNotNull() {
            addCriterion("person_en_name is not null");
            return (Criteria) this;
        }

        public Criteria andPersonEnNameEqualTo(String value) {
            addCriterion("person_en_name =", value, "personEnName");
            return (Criteria) this;
        }

        public Criteria andPersonEnNameNotEqualTo(String value) {
            addCriterion("person_en_name <>", value, "personEnName");
            return (Criteria) this;
        }

        public Criteria andPersonEnNameGreaterThan(String value) {
            addCriterion("person_en_name >", value, "personEnName");
            return (Criteria) this;
        }

        public Criteria andPersonEnNameGreaterThanOrEqualTo(String value) {
            addCriterion("person_en_name >=", value, "personEnName");
            return (Criteria) this;
        }

        public Criteria andPersonEnNameLessThan(String value) {
            addCriterion("person_en_name <", value, "personEnName");
            return (Criteria) this;
        }

        public Criteria andPersonEnNameLessThanOrEqualTo(String value) {
            addCriterion("person_en_name <=", value, "personEnName");
            return (Criteria) this;
        }

        public Criteria andPersonEnNameLike(String value) {
            addCriterion("person_en_name like", value, "personEnName");
            return (Criteria) this;
        }

        public Criteria andPersonEnNameNotLike(String value) {
            addCriterion("person_en_name not like", value, "personEnName");
            return (Criteria) this;
        }

        public Criteria andPersonEnNameIn(List<String> values) {
            addCriterion("person_en_name in", values, "personEnName");
            return (Criteria) this;
        }

        public Criteria andPersonEnNameNotIn(List<String> values) {
            addCriterion("person_en_name not in", values, "personEnName");
            return (Criteria) this;
        }

        public Criteria andPersonEnNameBetween(String value1, String value2) {
            addCriterion("person_en_name between", value1, value2, "personEnName");
            return (Criteria) this;
        }

        public Criteria andPersonEnNameNotBetween(String value1, String value2) {
            addCriterion("person_en_name not between", value1, value2, "personEnName");
            return (Criteria) this;
        }

        public Criteria andPersonEducationIsNull() {
            addCriterion("person_education is null");
            return (Criteria) this;
        }

        public Criteria andPersonEducationIsNotNull() {
            addCriterion("person_education is not null");
            return (Criteria) this;
        }

        public Criteria andPersonEducationEqualTo(Integer value) {
            addCriterion("person_education =", value, "personEducation");
            return (Criteria) this;
        }

        public Criteria andPersonEducationNotEqualTo(Integer value) {
            addCriterion("person_education <>", value, "personEducation");
            return (Criteria) this;
        }

        public Criteria andPersonEducationGreaterThan(Integer value) {
            addCriterion("person_education >", value, "personEducation");
            return (Criteria) this;
        }

        public Criteria andPersonEducationGreaterThanOrEqualTo(Integer value) {
            addCriterion("person_education >=", value, "personEducation");
            return (Criteria) this;
        }

        public Criteria andPersonEducationLessThan(Integer value) {
            addCriterion("person_education <", value, "personEducation");
            return (Criteria) this;
        }

        public Criteria andPersonEducationLessThanOrEqualTo(Integer value) {
            addCriterion("person_education <=", value, "personEducation");
            return (Criteria) this;
        }

        public Criteria andPersonEducationIn(List<Integer> values) {
            addCriterion("person_education in", values, "personEducation");
            return (Criteria) this;
        }

        public Criteria andPersonEducationNotIn(List<Integer> values) {
            addCriterion("person_education not in", values, "personEducation");
            return (Criteria) this;
        }

        public Criteria andPersonEducationBetween(Integer value1, Integer value2) {
            addCriterion("person_education between", value1, value2, "personEducation");
            return (Criteria) this;
        }

        public Criteria andPersonEducationNotBetween(Integer value1, Integer value2) {
            addCriterion("person_education not between", value1, value2, "personEducation");
            return (Criteria) this;
        }

        public Criteria andPersonRootPhoneIsNull() {
            addCriterion("person_root_phone is null");
            return (Criteria) this;
        }

        public Criteria andPersonRootPhoneIsNotNull() {
            addCriterion("person_root_phone is not null");
            return (Criteria) this;
        }

        public Criteria andPersonRootPhoneEqualTo(String value) {
            addCriterion("person_root_phone =", value, "personRootPhone");
            return (Criteria) this;
        }

        public Criteria andPersonRootPhoneNotEqualTo(String value) {
            addCriterion("person_root_phone <>", value, "personRootPhone");
            return (Criteria) this;
        }

        public Criteria andPersonRootPhoneGreaterThan(String value) {
            addCriterion("person_root_phone >", value, "personRootPhone");
            return (Criteria) this;
        }

        public Criteria andPersonRootPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("person_root_phone >=", value, "personRootPhone");
            return (Criteria) this;
        }

        public Criteria andPersonRootPhoneLessThan(String value) {
            addCriterion("person_root_phone <", value, "personRootPhone");
            return (Criteria) this;
        }

        public Criteria andPersonRootPhoneLessThanOrEqualTo(String value) {
            addCriterion("person_root_phone <=", value, "personRootPhone");
            return (Criteria) this;
        }

        public Criteria andPersonRootPhoneLike(String value) {
            addCriterion("person_root_phone like", value, "personRootPhone");
            return (Criteria) this;
        }

        public Criteria andPersonRootPhoneNotLike(String value) {
            addCriterion("person_root_phone not like", value, "personRootPhone");
            return (Criteria) this;
        }

        public Criteria andPersonRootPhoneIn(List<String> values) {
            addCriterion("person_root_phone in", values, "personRootPhone");
            return (Criteria) this;
        }

        public Criteria andPersonRootPhoneNotIn(List<String> values) {
            addCriterion("person_root_phone not in", values, "personRootPhone");
            return (Criteria) this;
        }

        public Criteria andPersonRootPhoneBetween(String value1, String value2) {
            addCriterion("person_root_phone between", value1, value2, "personRootPhone");
            return (Criteria) this;
        }

        public Criteria andPersonRootPhoneNotBetween(String value1, String value2) {
            addCriterion("person_root_phone not between", value1, value2, "personRootPhone");
            return (Criteria) this;
        }

        public Criteria andPersonRootAddrIsNull() {
            addCriterion("person_root_addr is null");
            return (Criteria) this;
        }

        public Criteria andPersonRootAddrIsNotNull() {
            addCriterion("person_root_addr is not null");
            return (Criteria) this;
        }

        public Criteria andPersonRootAddrEqualTo(String value) {
            addCriterion("person_root_addr =", value, "personRootAddr");
            return (Criteria) this;
        }

        public Criteria andPersonRootAddrNotEqualTo(String value) {
            addCriterion("person_root_addr <>", value, "personRootAddr");
            return (Criteria) this;
        }

        public Criteria andPersonRootAddrGreaterThan(String value) {
            addCriterion("person_root_addr >", value, "personRootAddr");
            return (Criteria) this;
        }

        public Criteria andPersonRootAddrGreaterThanOrEqualTo(String value) {
            addCriterion("person_root_addr >=", value, "personRootAddr");
            return (Criteria) this;
        }

        public Criteria andPersonRootAddrLessThan(String value) {
            addCriterion("person_root_addr <", value, "personRootAddr");
            return (Criteria) this;
        }

        public Criteria andPersonRootAddrLessThanOrEqualTo(String value) {
            addCriterion("person_root_addr <=", value, "personRootAddr");
            return (Criteria) this;
        }

        public Criteria andPersonRootAddrLike(String value) {
            addCriterion("person_root_addr like", value, "personRootAddr");
            return (Criteria) this;
        }

        public Criteria andPersonRootAddrNotLike(String value) {
            addCriterion("person_root_addr not like", value, "personRootAddr");
            return (Criteria) this;
        }

        public Criteria andPersonRootAddrIn(List<String> values) {
            addCriterion("person_root_addr in", values, "personRootAddr");
            return (Criteria) this;
        }

        public Criteria andPersonRootAddrNotIn(List<String> values) {
            addCriterion("person_root_addr not in", values, "personRootAddr");
            return (Criteria) this;
        }

        public Criteria andPersonRootAddrBetween(String value1, String value2) {
            addCriterion("person_root_addr between", value1, value2, "personRootAddr");
            return (Criteria) this;
        }

        public Criteria andPersonRootAddrNotBetween(String value1, String value2) {
            addCriterion("person_root_addr not between", value1, value2, "personRootAddr");
            return (Criteria) this;
        }

        public Criteria andPersonCurrentAddrIsNull() {
            addCriterion("person_current_addr is null");
            return (Criteria) this;
        }

        public Criteria andPersonCurrentAddrIsNotNull() {
            addCriterion("person_current_addr is not null");
            return (Criteria) this;
        }

        public Criteria andPersonCurrentAddrEqualTo(String value) {
            addCriterion("person_current_addr =", value, "personCurrentAddr");
            return (Criteria) this;
        }

        public Criteria andPersonCurrentAddrNotEqualTo(String value) {
            addCriterion("person_current_addr <>", value, "personCurrentAddr");
            return (Criteria) this;
        }

        public Criteria andPersonCurrentAddrGreaterThan(String value) {
            addCriterion("person_current_addr >", value, "personCurrentAddr");
            return (Criteria) this;
        }

        public Criteria andPersonCurrentAddrGreaterThanOrEqualTo(String value) {
            addCriterion("person_current_addr >=", value, "personCurrentAddr");
            return (Criteria) this;
        }

        public Criteria andPersonCurrentAddrLessThan(String value) {
            addCriterion("person_current_addr <", value, "personCurrentAddr");
            return (Criteria) this;
        }

        public Criteria andPersonCurrentAddrLessThanOrEqualTo(String value) {
            addCriterion("person_current_addr <=", value, "personCurrentAddr");
            return (Criteria) this;
        }

        public Criteria andPersonCurrentAddrLike(String value) {
            addCriterion("person_current_addr like", value, "personCurrentAddr");
            return (Criteria) this;
        }

        public Criteria andPersonCurrentAddrNotLike(String value) {
            addCriterion("person_current_addr not like", value, "personCurrentAddr");
            return (Criteria) this;
        }

        public Criteria andPersonCurrentAddrIn(List<String> values) {
            addCriterion("person_current_addr in", values, "personCurrentAddr");
            return (Criteria) this;
        }

        public Criteria andPersonCurrentAddrNotIn(List<String> values) {
            addCriterion("person_current_addr not in", values, "personCurrentAddr");
            return (Criteria) this;
        }

        public Criteria andPersonCurrentAddrBetween(String value1, String value2) {
            addCriterion("person_current_addr between", value1, value2, "personCurrentAddr");
            return (Criteria) this;
        }

        public Criteria andPersonCurrentAddrNotBetween(String value1, String value2) {
            addCriterion("person_current_addr not between", value1, value2, "personCurrentAddr");
            return (Criteria) this;
        }

        public Criteria andPersonCurrentAddrTypeIsNull() {
            addCriterion("person_current_addr_type is null");
            return (Criteria) this;
        }

        public Criteria andPersonCurrentAddrTypeIsNotNull() {
            addCriterion("person_current_addr_type is not null");
            return (Criteria) this;
        }

        public Criteria andPersonCurrentAddrTypeEqualTo(Integer value) {
            addCriterion("person_current_addr_type =", value, "personCurrentAddrType");
            return (Criteria) this;
        }

        public Criteria andPersonCurrentAddrTypeNotEqualTo(Integer value) {
            addCriterion("person_current_addr_type <>", value, "personCurrentAddrType");
            return (Criteria) this;
        }

        public Criteria andPersonCurrentAddrTypeGreaterThan(Integer value) {
            addCriterion("person_current_addr_type >", value, "personCurrentAddrType");
            return (Criteria) this;
        }

        public Criteria andPersonCurrentAddrTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("person_current_addr_type >=", value, "personCurrentAddrType");
            return (Criteria) this;
        }

        public Criteria andPersonCurrentAddrTypeLessThan(Integer value) {
            addCriterion("person_current_addr_type <", value, "personCurrentAddrType");
            return (Criteria) this;
        }

        public Criteria andPersonCurrentAddrTypeLessThanOrEqualTo(Integer value) {
            addCriterion("person_current_addr_type <=", value, "personCurrentAddrType");
            return (Criteria) this;
        }

        public Criteria andPersonCurrentAddrTypeIn(List<Integer> values) {
            addCriterion("person_current_addr_type in", values, "personCurrentAddrType");
            return (Criteria) this;
        }

        public Criteria andPersonCurrentAddrTypeNotIn(List<Integer> values) {
            addCriterion("person_current_addr_type not in", values, "personCurrentAddrType");
            return (Criteria) this;
        }

        public Criteria andPersonCurrentAddrTypeBetween(Integer value1, Integer value2) {
            addCriterion("person_current_addr_type between", value1, value2, "personCurrentAddrType");
            return (Criteria) this;
        }

        public Criteria andPersonCurrentAddrTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("person_current_addr_type not between", value1, value2, "personCurrentAddrType");
            return (Criteria) this;
        }

        public Criteria andPersonCurrentPhoneIsNull() {
            addCriterion("person_current_phone is null");
            return (Criteria) this;
        }

        public Criteria andPersonCurrentPhoneIsNotNull() {
            addCriterion("person_current_phone is not null");
            return (Criteria) this;
        }

        public Criteria andPersonCurrentPhoneEqualTo(String value) {
            addCriterion("person_current_phone =", value, "personCurrentPhone");
            return (Criteria) this;
        }

        public Criteria andPersonCurrentPhoneNotEqualTo(String value) {
            addCriterion("person_current_phone <>", value, "personCurrentPhone");
            return (Criteria) this;
        }

        public Criteria andPersonCurrentPhoneGreaterThan(String value) {
            addCriterion("person_current_phone >", value, "personCurrentPhone");
            return (Criteria) this;
        }

        public Criteria andPersonCurrentPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("person_current_phone >=", value, "personCurrentPhone");
            return (Criteria) this;
        }

        public Criteria andPersonCurrentPhoneLessThan(String value) {
            addCriterion("person_current_phone <", value, "personCurrentPhone");
            return (Criteria) this;
        }

        public Criteria andPersonCurrentPhoneLessThanOrEqualTo(String value) {
            addCriterion("person_current_phone <=", value, "personCurrentPhone");
            return (Criteria) this;
        }

        public Criteria andPersonCurrentPhoneLike(String value) {
            addCriterion("person_current_phone like", value, "personCurrentPhone");
            return (Criteria) this;
        }

        public Criteria andPersonCurrentPhoneNotLike(String value) {
            addCriterion("person_current_phone not like", value, "personCurrentPhone");
            return (Criteria) this;
        }

        public Criteria andPersonCurrentPhoneIn(List<String> values) {
            addCriterion("person_current_phone in", values, "personCurrentPhone");
            return (Criteria) this;
        }

        public Criteria andPersonCurrentPhoneNotIn(List<String> values) {
            addCriterion("person_current_phone not in", values, "personCurrentPhone");
            return (Criteria) this;
        }

        public Criteria andPersonCurrentPhoneBetween(String value1, String value2) {
            addCriterion("person_current_phone between", value1, value2, "personCurrentPhone");
            return (Criteria) this;
        }

        public Criteria andPersonCurrentPhoneNotBetween(String value1, String value2) {
            addCriterion("person_current_phone not between", value1, value2, "personCurrentPhone");
            return (Criteria) this;
        }

        public Criteria andCardSendTypeIsNull() {
            addCriterion("card_send_type is null");
            return (Criteria) this;
        }

        public Criteria andCardSendTypeIsNotNull() {
            addCriterion("card_send_type is not null");
            return (Criteria) this;
        }

        public Criteria andCardSendTypeEqualTo(Integer value) {
            addCriterion("card_send_type =", value, "cardSendType");
            return (Criteria) this;
        }

        public Criteria andCardSendTypeNotEqualTo(Integer value) {
            addCriterion("card_send_type <>", value, "cardSendType");
            return (Criteria) this;
        }

        public Criteria andCardSendTypeGreaterThan(Integer value) {
            addCriterion("card_send_type >", value, "cardSendType");
            return (Criteria) this;
        }

        public Criteria andCardSendTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("card_send_type >=", value, "cardSendType");
            return (Criteria) this;
        }

        public Criteria andCardSendTypeLessThan(Integer value) {
            addCriterion("card_send_type <", value, "cardSendType");
            return (Criteria) this;
        }

        public Criteria andCardSendTypeLessThanOrEqualTo(Integer value) {
            addCriterion("card_send_type <=", value, "cardSendType");
            return (Criteria) this;
        }

        public Criteria andCardSendTypeIn(List<Integer> values) {
            addCriterion("card_send_type in", values, "cardSendType");
            return (Criteria) this;
        }

        public Criteria andCardSendTypeNotIn(List<Integer> values) {
            addCriterion("card_send_type not in", values, "cardSendType");
            return (Criteria) this;
        }

        public Criteria andCardSendTypeBetween(Integer value1, Integer value2) {
            addCriterion("card_send_type between", value1, value2, "cardSendType");
            return (Criteria) this;
        }

        public Criteria andCardSendTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("card_send_type not between", value1, value2, "cardSendType");
            return (Criteria) this;
        }

        public Criteria andEbillSendTypeIsNull() {
            addCriterion("ebill_send_type is null");
            return (Criteria) this;
        }

        public Criteria andEbillSendTypeIsNotNull() {
            addCriterion("ebill_send_type is not null");
            return (Criteria) this;
        }

        public Criteria andEbillSendTypeEqualTo(Integer value) {
            addCriterion("ebill_send_type =", value, "ebillSendType");
            return (Criteria) this;
        }

        public Criteria andEbillSendTypeNotEqualTo(Integer value) {
            addCriterion("ebill_send_type <>", value, "ebillSendType");
            return (Criteria) this;
        }

        public Criteria andEbillSendTypeGreaterThan(Integer value) {
            addCriterion("ebill_send_type >", value, "ebillSendType");
            return (Criteria) this;
        }

        public Criteria andEbillSendTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ebill_send_type >=", value, "ebillSendType");
            return (Criteria) this;
        }

        public Criteria andEbillSendTypeLessThan(Integer value) {
            addCriterion("ebill_send_type <", value, "ebillSendType");
            return (Criteria) this;
        }

        public Criteria andEbillSendTypeLessThanOrEqualTo(Integer value) {
            addCriterion("ebill_send_type <=", value, "ebillSendType");
            return (Criteria) this;
        }

        public Criteria andEbillSendTypeIn(List<Integer> values) {
            addCriterion("ebill_send_type in", values, "ebillSendType");
            return (Criteria) this;
        }

        public Criteria andEbillSendTypeNotIn(List<Integer> values) {
            addCriterion("ebill_send_type not in", values, "ebillSendType");
            return (Criteria) this;
        }

        public Criteria andEbillSendTypeBetween(Integer value1, Integer value2) {
            addCriterion("ebill_send_type between", value1, value2, "ebillSendType");
            return (Criteria) this;
        }

        public Criteria andEbillSendTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("ebill_send_type not between", value1, value2, "ebillSendType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeIsNull() {
            addCriterion("company_type is null");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeIsNotNull() {
            addCriterion("company_type is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeEqualTo(String value) {
            addCriterion("company_type =", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeNotEqualTo(String value) {
            addCriterion("company_type <>", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeGreaterThan(String value) {
            addCriterion("company_type >", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("company_type >=", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeLessThan(String value) {
            addCriterion("company_type <", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeLessThanOrEqualTo(String value) {
            addCriterion("company_type <=", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeLike(String value) {
            addCriterion("company_type like", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeNotLike(String value) {
            addCriterion("company_type not like", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeIn(List<String> values) {
            addCriterion("company_type in", values, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeNotIn(List<String> values) {
            addCriterion("company_type not in", values, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeBetween(String value1, String value2) {
            addCriterion("company_type between", value1, value2, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeNotBetween(String value1, String value2) {
            addCriterion("company_type not between", value1, value2, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyJobNameIsNull() {
            addCriterion("company_job_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyJobNameIsNotNull() {
            addCriterion("company_job_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyJobNameEqualTo(String value) {
            addCriterion("company_job_name =", value, "companyJobName");
            return (Criteria) this;
        }

        public Criteria andCompanyJobNameNotEqualTo(String value) {
            addCriterion("company_job_name <>", value, "companyJobName");
            return (Criteria) this;
        }

        public Criteria andCompanyJobNameGreaterThan(String value) {
            addCriterion("company_job_name >", value, "companyJobName");
            return (Criteria) this;
        }

        public Criteria andCompanyJobNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_job_name >=", value, "companyJobName");
            return (Criteria) this;
        }

        public Criteria andCompanyJobNameLessThan(String value) {
            addCriterion("company_job_name <", value, "companyJobName");
            return (Criteria) this;
        }

        public Criteria andCompanyJobNameLessThanOrEqualTo(String value) {
            addCriterion("company_job_name <=", value, "companyJobName");
            return (Criteria) this;
        }

        public Criteria andCompanyJobNameLike(String value) {
            addCriterion("company_job_name like", value, "companyJobName");
            return (Criteria) this;
        }

        public Criteria andCompanyJobNameNotLike(String value) {
            addCriterion("company_job_name not like", value, "companyJobName");
            return (Criteria) this;
        }

        public Criteria andCompanyJobNameIn(List<String> values) {
            addCriterion("company_job_name in", values, "companyJobName");
            return (Criteria) this;
        }

        public Criteria andCompanyJobNameNotIn(List<String> values) {
            addCriterion("company_job_name not in", values, "companyJobName");
            return (Criteria) this;
        }

        public Criteria andCompanyJobNameBetween(String value1, String value2) {
            addCriterion("company_job_name between", value1, value2, "companyJobName");
            return (Criteria) this;
        }

        public Criteria andCompanyJobNameNotBetween(String value1, String value2) {
            addCriterion("company_job_name not between", value1, value2, "companyJobName");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneIsNull() {
            addCriterion("company_phone is null");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneIsNotNull() {
            addCriterion("company_phone is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneEqualTo(String value) {
            addCriterion("company_phone =", value, "companyPhone");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneNotEqualTo(String value) {
            addCriterion("company_phone <>", value, "companyPhone");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneGreaterThan(String value) {
            addCriterion("company_phone >", value, "companyPhone");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("company_phone >=", value, "companyPhone");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneLessThan(String value) {
            addCriterion("company_phone <", value, "companyPhone");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneLessThanOrEqualTo(String value) {
            addCriterion("company_phone <=", value, "companyPhone");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneLike(String value) {
            addCriterion("company_phone like", value, "companyPhone");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneNotLike(String value) {
            addCriterion("company_phone not like", value, "companyPhone");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneIn(List<String> values) {
            addCriterion("company_phone in", values, "companyPhone");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneNotIn(List<String> values) {
            addCriterion("company_phone not in", values, "companyPhone");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneBetween(String value1, String value2) {
            addCriterion("company_phone between", value1, value2, "companyPhone");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneNotBetween(String value1, String value2) {
            addCriterion("company_phone not between", value1, value2, "companyPhone");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrIsNull() {
            addCriterion("company_addr is null");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrIsNotNull() {
            addCriterion("company_addr is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrEqualTo(String value) {
            addCriterion("company_addr =", value, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrNotEqualTo(String value) {
            addCriterion("company_addr <>", value, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrGreaterThan(String value) {
            addCriterion("company_addr >", value, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrGreaterThanOrEqualTo(String value) {
            addCriterion("company_addr >=", value, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrLessThan(String value) {
            addCriterion("company_addr <", value, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrLessThanOrEqualTo(String value) {
            addCriterion("company_addr <=", value, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrLike(String value) {
            addCriterion("company_addr like", value, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrNotLike(String value) {
            addCriterion("company_addr not like", value, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrIn(List<String> values) {
            addCriterion("company_addr in", values, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrNotIn(List<String> values) {
            addCriterion("company_addr not in", values, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrBetween(String value1, String value2) {
            addCriterion("company_addr between", value1, value2, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrNotBetween(String value1, String value2) {
            addCriterion("company_addr not between", value1, value2, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andArticleCommonIsNull() {
            addCriterion("article_common is null");
            return (Criteria) this;
        }

        public Criteria andArticleCommonIsNotNull() {
            addCriterion("article_common is not null");
            return (Criteria) this;
        }

        public Criteria andArticleCommonEqualTo(Integer value) {
            addCriterion("article_common =", value, "articleCommon");
            return (Criteria) this;
        }

        public Criteria andArticleCommonNotEqualTo(Integer value) {
            addCriterion("article_common <>", value, "articleCommon");
            return (Criteria) this;
        }

        public Criteria andArticleCommonGreaterThan(Integer value) {
            addCriterion("article_common >", value, "articleCommon");
            return (Criteria) this;
        }

        public Criteria andArticleCommonGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_common >=", value, "articleCommon");
            return (Criteria) this;
        }

        public Criteria andArticleCommonLessThan(Integer value) {
            addCriterion("article_common <", value, "articleCommon");
            return (Criteria) this;
        }

        public Criteria andArticleCommonLessThanOrEqualTo(Integer value) {
            addCriterion("article_common <=", value, "articleCommon");
            return (Criteria) this;
        }

        public Criteria andArticleCommonIn(List<Integer> values) {
            addCriterion("article_common in", values, "articleCommon");
            return (Criteria) this;
        }

        public Criteria andArticleCommonNotIn(List<Integer> values) {
            addCriterion("article_common not in", values, "articleCommon");
            return (Criteria) this;
        }

        public Criteria andArticleCommonBetween(Integer value1, Integer value2) {
            addCriterion("article_common between", value1, value2, "articleCommon");
            return (Criteria) this;
        }

        public Criteria andArticleCommonNotBetween(Integer value1, Integer value2) {
            addCriterion("article_common not between", value1, value2, "articleCommon");
            return (Criteria) this;
        }

        public Criteria andArticleEbillIsNull() {
            addCriterion("article_ebill is null");
            return (Criteria) this;
        }

        public Criteria andArticleEbillIsNotNull() {
            addCriterion("article_ebill is not null");
            return (Criteria) this;
        }

        public Criteria andArticleEbillEqualTo(Integer value) {
            addCriterion("article_ebill =", value, "articleEbill");
            return (Criteria) this;
        }

        public Criteria andArticleEbillNotEqualTo(Integer value) {
            addCriterion("article_ebill <>", value, "articleEbill");
            return (Criteria) this;
        }

        public Criteria andArticleEbillGreaterThan(Integer value) {
            addCriterion("article_ebill >", value, "articleEbill");
            return (Criteria) this;
        }

        public Criteria andArticleEbillGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_ebill >=", value, "articleEbill");
            return (Criteria) this;
        }

        public Criteria andArticleEbillLessThan(Integer value) {
            addCriterion("article_ebill <", value, "articleEbill");
            return (Criteria) this;
        }

        public Criteria andArticleEbillLessThanOrEqualTo(Integer value) {
            addCriterion("article_ebill <=", value, "articleEbill");
            return (Criteria) this;
        }

        public Criteria andArticleEbillIn(List<Integer> values) {
            addCriterion("article_ebill in", values, "articleEbill");
            return (Criteria) this;
        }

        public Criteria andArticleEbillNotIn(List<Integer> values) {
            addCriterion("article_ebill not in", values, "articleEbill");
            return (Criteria) this;
        }

        public Criteria andArticleEbillBetween(Integer value1, Integer value2) {
            addCriterion("article_ebill between", value1, value2, "articleEbill");
            return (Criteria) this;
        }

        public Criteria andArticleEbillNotBetween(Integer value1, Integer value2) {
            addCriterion("article_ebill not between", value1, value2, "articleEbill");
            return (Criteria) this;
        }

        public Criteria andArticleMarketingIsNull() {
            addCriterion("article_marketing is null");
            return (Criteria) this;
        }

        public Criteria andArticleMarketingIsNotNull() {
            addCriterion("article_marketing is not null");
            return (Criteria) this;
        }

        public Criteria andArticleMarketingEqualTo(Integer value) {
            addCriterion("article_marketing =", value, "articleMarketing");
            return (Criteria) this;
        }

        public Criteria andArticleMarketingNotEqualTo(Integer value) {
            addCriterion("article_marketing <>", value, "articleMarketing");
            return (Criteria) this;
        }

        public Criteria andArticleMarketingGreaterThan(Integer value) {
            addCriterion("article_marketing >", value, "articleMarketing");
            return (Criteria) this;
        }

        public Criteria andArticleMarketingGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_marketing >=", value, "articleMarketing");
            return (Criteria) this;
        }

        public Criteria andArticleMarketingLessThan(Integer value) {
            addCriterion("article_marketing <", value, "articleMarketing");
            return (Criteria) this;
        }

        public Criteria andArticleMarketingLessThanOrEqualTo(Integer value) {
            addCriterion("article_marketing <=", value, "articleMarketing");
            return (Criteria) this;
        }

        public Criteria andArticleMarketingIn(List<Integer> values) {
            addCriterion("article_marketing in", values, "articleMarketing");
            return (Criteria) this;
        }

        public Criteria andArticleMarketingNotIn(List<Integer> values) {
            addCriterion("article_marketing not in", values, "articleMarketing");
            return (Criteria) this;
        }

        public Criteria andArticleMarketingBetween(Integer value1, Integer value2) {
            addCriterion("article_marketing between", value1, value2, "articleMarketing");
            return (Criteria) this;
        }

        public Criteria andArticleMarketingNotBetween(Integer value1, Integer value2) {
            addCriterion("article_marketing not between", value1, value2, "articleMarketing");
            return (Criteria) this;
        }

        public Criteria andUploadIdcardIsNull() {
            addCriterion("upload_idcard is null");
            return (Criteria) this;
        }

        public Criteria andUploadIdcardIsNotNull() {
            addCriterion("upload_idcard is not null");
            return (Criteria) this;
        }

        public Criteria andUploadIdcardEqualTo(Integer value) {
            addCriterion("upload_idcard =", value, "uploadIdcard");
            return (Criteria) this;
        }

        public Criteria andUploadIdcardNotEqualTo(Integer value) {
            addCriterion("upload_idcard <>", value, "uploadIdcard");
            return (Criteria) this;
        }

        public Criteria andUploadIdcardGreaterThan(Integer value) {
            addCriterion("upload_idcard >", value, "uploadIdcard");
            return (Criteria) this;
        }

        public Criteria andUploadIdcardGreaterThanOrEqualTo(Integer value) {
            addCriterion("upload_idcard >=", value, "uploadIdcard");
            return (Criteria) this;
        }

        public Criteria andUploadIdcardLessThan(Integer value) {
            addCriterion("upload_idcard <", value, "uploadIdcard");
            return (Criteria) this;
        }

        public Criteria andUploadIdcardLessThanOrEqualTo(Integer value) {
            addCriterion("upload_idcard <=", value, "uploadIdcard");
            return (Criteria) this;
        }

        public Criteria andUploadIdcardIn(List<Integer> values) {
            addCriterion("upload_idcard in", values, "uploadIdcard");
            return (Criteria) this;
        }

        public Criteria andUploadIdcardNotIn(List<Integer> values) {
            addCriterion("upload_idcard not in", values, "uploadIdcard");
            return (Criteria) this;
        }

        public Criteria andUploadIdcardBetween(Integer value1, Integer value2) {
            addCriterion("upload_idcard between", value1, value2, "uploadIdcard");
            return (Criteria) this;
        }

        public Criteria andUploadIdcardNotBetween(Integer value1, Integer value2) {
            addCriterion("upload_idcard not between", value1, value2, "uploadIdcard");
            return (Criteria) this;
        }

        public Criteria andUploadIdcardReverseIsNull() {
            addCriterion("upload_idcard_reverse is null");
            return (Criteria) this;
        }

        public Criteria andUploadIdcardReverseIsNotNull() {
            addCriterion("upload_idcard_reverse is not null");
            return (Criteria) this;
        }

        public Criteria andUploadIdcardReverseEqualTo(Integer value) {
            addCriterion("upload_idcard_reverse =", value, "uploadIdcardReverse");
            return (Criteria) this;
        }

        public Criteria andUploadIdcardReverseNotEqualTo(Integer value) {
            addCriterion("upload_idcard_reverse <>", value, "uploadIdcardReverse");
            return (Criteria) this;
        }

        public Criteria andUploadIdcardReverseGreaterThan(Integer value) {
            addCriterion("upload_idcard_reverse >", value, "uploadIdcardReverse");
            return (Criteria) this;
        }

        public Criteria andUploadIdcardReverseGreaterThanOrEqualTo(Integer value) {
            addCriterion("upload_idcard_reverse >=", value, "uploadIdcardReverse");
            return (Criteria) this;
        }

        public Criteria andUploadIdcardReverseLessThan(Integer value) {
            addCriterion("upload_idcard_reverse <", value, "uploadIdcardReverse");
            return (Criteria) this;
        }

        public Criteria andUploadIdcardReverseLessThanOrEqualTo(Integer value) {
            addCriterion("upload_idcard_reverse <=", value, "uploadIdcardReverse");
            return (Criteria) this;
        }

        public Criteria andUploadIdcardReverseIn(List<Integer> values) {
            addCriterion("upload_idcard_reverse in", values, "uploadIdcardReverse");
            return (Criteria) this;
        }

        public Criteria andUploadIdcardReverseNotIn(List<Integer> values) {
            addCriterion("upload_idcard_reverse not in", values, "uploadIdcardReverse");
            return (Criteria) this;
        }

        public Criteria andUploadIdcardReverseBetween(Integer value1, Integer value2) {
            addCriterion("upload_idcard_reverse between", value1, value2, "uploadIdcardReverse");
            return (Criteria) this;
        }

        public Criteria andUploadIdcardReverseNotBetween(Integer value1, Integer value2) {
            addCriterion("upload_idcard_reverse not between", value1, value2, "uploadIdcardReverse");
            return (Criteria) this;
        }

        public Criteria andUploadBusinessCardIsNull() {
            addCriterion("upload_business_card is null");
            return (Criteria) this;
        }

        public Criteria andUploadBusinessCardIsNotNull() {
            addCriterion("upload_business_card is not null");
            return (Criteria) this;
        }

        public Criteria andUploadBusinessCardEqualTo(Integer value) {
            addCriterion("upload_business_card =", value, "uploadBusinessCard");
            return (Criteria) this;
        }

        public Criteria andUploadBusinessCardNotEqualTo(Integer value) {
            addCriterion("upload_business_card <>", value, "uploadBusinessCard");
            return (Criteria) this;
        }

        public Criteria andUploadBusinessCardGreaterThan(Integer value) {
            addCriterion("upload_business_card >", value, "uploadBusinessCard");
            return (Criteria) this;
        }

        public Criteria andUploadBusinessCardGreaterThanOrEqualTo(Integer value) {
            addCriterion("upload_business_card >=", value, "uploadBusinessCard");
            return (Criteria) this;
        }

        public Criteria andUploadBusinessCardLessThan(Integer value) {
            addCriterion("upload_business_card <", value, "uploadBusinessCard");
            return (Criteria) this;
        }

        public Criteria andUploadBusinessCardLessThanOrEqualTo(Integer value) {
            addCriterion("upload_business_card <=", value, "uploadBusinessCard");
            return (Criteria) this;
        }

        public Criteria andUploadBusinessCardIn(List<Integer> values) {
            addCriterion("upload_business_card in", values, "uploadBusinessCard");
            return (Criteria) this;
        }

        public Criteria andUploadBusinessCardNotIn(List<Integer> values) {
            addCriterion("upload_business_card not in", values, "uploadBusinessCard");
            return (Criteria) this;
        }

        public Criteria andUploadBusinessCardBetween(Integer value1, Integer value2) {
            addCriterion("upload_business_card between", value1, value2, "uploadBusinessCard");
            return (Criteria) this;
        }

        public Criteria andUploadBusinessCardNotBetween(Integer value1, Integer value2) {
            addCriterion("upload_business_card not between", value1, value2, "uploadBusinessCard");
            return (Criteria) this;
        }

        public Criteria andUploadFinancialPaperIsNull() {
            addCriterion("upload_financial_paper is null");
            return (Criteria) this;
        }

        public Criteria andUploadFinancialPaperIsNotNull() {
            addCriterion("upload_financial_paper is not null");
            return (Criteria) this;
        }

        public Criteria andUploadFinancialPaperEqualTo(Integer value) {
            addCriterion("upload_financial_paper =", value, "uploadFinancialPaper");
            return (Criteria) this;
        }

        public Criteria andUploadFinancialPaperNotEqualTo(Integer value) {
            addCriterion("upload_financial_paper <>", value, "uploadFinancialPaper");
            return (Criteria) this;
        }

        public Criteria andUploadFinancialPaperGreaterThan(Integer value) {
            addCriterion("upload_financial_paper >", value, "uploadFinancialPaper");
            return (Criteria) this;
        }

        public Criteria andUploadFinancialPaperGreaterThanOrEqualTo(Integer value) {
            addCriterion("upload_financial_paper >=", value, "uploadFinancialPaper");
            return (Criteria) this;
        }

        public Criteria andUploadFinancialPaperLessThan(Integer value) {
            addCriterion("upload_financial_paper <", value, "uploadFinancialPaper");
            return (Criteria) this;
        }

        public Criteria andUploadFinancialPaperLessThanOrEqualTo(Integer value) {
            addCriterion("upload_financial_paper <=", value, "uploadFinancialPaper");
            return (Criteria) this;
        }

        public Criteria andUploadFinancialPaperIn(List<Integer> values) {
            addCriterion("upload_financial_paper in", values, "uploadFinancialPaper");
            return (Criteria) this;
        }

        public Criteria andUploadFinancialPaperNotIn(List<Integer> values) {
            addCriterion("upload_financial_paper not in", values, "uploadFinancialPaper");
            return (Criteria) this;
        }

        public Criteria andUploadFinancialPaperBetween(Integer value1, Integer value2) {
            addCriterion("upload_financial_paper between", value1, value2, "uploadFinancialPaper");
            return (Criteria) this;
        }

        public Criteria andUploadFinancialPaperNotBetween(Integer value1, Integer value2) {
            addCriterion("upload_financial_paper not between", value1, value2, "uploadFinancialPaper");
            return (Criteria) this;
        }

        public Criteria andEnableAdditionalIsNull() {
            addCriterion("enable_additional is null");
            return (Criteria) this;
        }

        public Criteria andEnableAdditionalIsNotNull() {
            addCriterion("enable_additional is not null");
            return (Criteria) this;
        }

        public Criteria andEnableAdditionalEqualTo(Integer value) {
            addCriterion("enable_additional =", value, "enableAdditional");
            return (Criteria) this;
        }

        public Criteria andEnableAdditionalNotEqualTo(Integer value) {
            addCriterion("enable_additional <>", value, "enableAdditional");
            return (Criteria) this;
        }

        public Criteria andEnableAdditionalGreaterThan(Integer value) {
            addCriterion("enable_additional >", value, "enableAdditional");
            return (Criteria) this;
        }

        public Criteria andEnableAdditionalGreaterThanOrEqualTo(Integer value) {
            addCriterion("enable_additional >=", value, "enableAdditional");
            return (Criteria) this;
        }

        public Criteria andEnableAdditionalLessThan(Integer value) {
            addCriterion("enable_additional <", value, "enableAdditional");
            return (Criteria) this;
        }

        public Criteria andEnableAdditionalLessThanOrEqualTo(Integer value) {
            addCriterion("enable_additional <=", value, "enableAdditional");
            return (Criteria) this;
        }

        public Criteria andEnableAdditionalIn(List<Integer> values) {
            addCriterion("enable_additional in", values, "enableAdditional");
            return (Criteria) this;
        }

        public Criteria andEnableAdditionalNotIn(List<Integer> values) {
            addCriterion("enable_additional not in", values, "enableAdditional");
            return (Criteria) this;
        }

        public Criteria andEnableAdditionalBetween(Integer value1, Integer value2) {
            addCriterion("enable_additional between", value1, value2, "enableAdditional");
            return (Criteria) this;
        }

        public Criteria andEnableAdditionalNotBetween(Integer value1, Integer value2) {
            addCriterion("enable_additional not between", value1, value2, "enableAdditional");
            return (Criteria) this;
        }

        public Criteria andEnableCashPasswordIsNull() {
            addCriterion("enable_cash_password is null");
            return (Criteria) this;
        }

        public Criteria andEnableCashPasswordIsNotNull() {
            addCriterion("enable_cash_password is not null");
            return (Criteria) this;
        }

        public Criteria andEnableCashPasswordEqualTo(Integer value) {
            addCriterion("enable_cash_password =", value, "enableCashPassword");
            return (Criteria) this;
        }

        public Criteria andEnableCashPasswordNotEqualTo(Integer value) {
            addCriterion("enable_cash_password <>", value, "enableCashPassword");
            return (Criteria) this;
        }

        public Criteria andEnableCashPasswordGreaterThan(Integer value) {
            addCriterion("enable_cash_password >", value, "enableCashPassword");
            return (Criteria) this;
        }

        public Criteria andEnableCashPasswordGreaterThanOrEqualTo(Integer value) {
            addCriterion("enable_cash_password >=", value, "enableCashPassword");
            return (Criteria) this;
        }

        public Criteria andEnableCashPasswordLessThan(Integer value) {
            addCriterion("enable_cash_password <", value, "enableCashPassword");
            return (Criteria) this;
        }

        public Criteria andEnableCashPasswordLessThanOrEqualTo(Integer value) {
            addCriterion("enable_cash_password <=", value, "enableCashPassword");
            return (Criteria) this;
        }

        public Criteria andEnableCashPasswordIn(List<Integer> values) {
            addCriterion("enable_cash_password in", values, "enableCashPassword");
            return (Criteria) this;
        }

        public Criteria andEnableCashPasswordNotIn(List<Integer> values) {
            addCriterion("enable_cash_password not in", values, "enableCashPassword");
            return (Criteria) this;
        }

        public Criteria andEnableCashPasswordBetween(Integer value1, Integer value2) {
            addCriterion("enable_cash_password between", value1, value2, "enableCashPassword");
            return (Criteria) this;
        }

        public Criteria andEnableCashPasswordNotBetween(Integer value1, Integer value2) {
            addCriterion("enable_cash_password not between", value1, value2, "enableCashPassword");
            return (Criteria) this;
        }

        public Criteria andCaseStatusIsNull() {
            addCriterion("case_status is null");
            return (Criteria) this;
        }

        public Criteria andCaseStatusIsNotNull() {
            addCriterion("case_status is not null");
            return (Criteria) this;
        }

        public Criteria andCaseStatusEqualTo(String value) {
            addCriterion("case_status =", value, "caseStatus");
            return (Criteria) this;
        }

        public Criteria andCaseStatusNotEqualTo(String value) {
            addCriterion("case_status <>", value, "caseStatus");
            return (Criteria) this;
        }

        public Criteria andCaseStatusGreaterThan(String value) {
            addCriterion("case_status >", value, "caseStatus");
            return (Criteria) this;
        }

        public Criteria andCaseStatusGreaterThanOrEqualTo(String value) {
            addCriterion("case_status >=", value, "caseStatus");
            return (Criteria) this;
        }

        public Criteria andCaseStatusLessThan(String value) {
            addCriterion("case_status <", value, "caseStatus");
            return (Criteria) this;
        }

        public Criteria andCaseStatusLessThanOrEqualTo(String value) {
            addCriterion("case_status <=", value, "caseStatus");
            return (Criteria) this;
        }

        public Criteria andCaseStatusLike(String value) {
            addCriterion("case_status like", value, "caseStatus");
            return (Criteria) this;
        }

        public Criteria andCaseStatusNotLike(String value) {
            addCriterion("case_status not like", value, "caseStatus");
            return (Criteria) this;
        }

        public Criteria andCaseStatusIn(List<String> values) {
            addCriterion("case_status in", values, "caseStatus");
            return (Criteria) this;
        }

        public Criteria andCaseStatusNotIn(List<String> values) {
            addCriterion("case_status not in", values, "caseStatus");
            return (Criteria) this;
        }

        public Criteria andCaseStatusBetween(String value1, String value2) {
            addCriterion("case_status between", value1, value2, "caseStatus");
            return (Criteria) this;
        }

        public Criteria andCaseStatusNotBetween(String value1, String value2) {
            addCriterion("case_status not between", value1, value2, "caseStatus");
            return (Criteria) this;
        }

        public Criteria andNeedComplementNumIsNull() {
            addCriterion("need_complement_num is null");
            return (Criteria) this;
        }

        public Criteria andNeedComplementNumIsNotNull() {
            addCriterion("need_complement_num is not null");
            return (Criteria) this;
        }

        public Criteria andNeedComplementNumEqualTo(Integer value) {
            addCriterion("need_complement_num =", value, "needComplementNum");
            return (Criteria) this;
        }

        public Criteria andNeedComplementNumNotEqualTo(Integer value) {
            addCriterion("need_complement_num <>", value, "needComplementNum");
            return (Criteria) this;
        }

        public Criteria andNeedComplementNumGreaterThan(Integer value) {
            addCriterion("need_complement_num >", value, "needComplementNum");
            return (Criteria) this;
        }

        public Criteria andNeedComplementNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("need_complement_num >=", value, "needComplementNum");
            return (Criteria) this;
        }

        public Criteria andNeedComplementNumLessThan(Integer value) {
            addCriterion("need_complement_num <", value, "needComplementNum");
            return (Criteria) this;
        }

        public Criteria andNeedComplementNumLessThanOrEqualTo(Integer value) {
            addCriterion("need_complement_num <=", value, "needComplementNum");
            return (Criteria) this;
        }

        public Criteria andNeedComplementNumIn(List<Integer> values) {
            addCriterion("need_complement_num in", values, "needComplementNum");
            return (Criteria) this;
        }

        public Criteria andNeedComplementNumNotIn(List<Integer> values) {
            addCriterion("need_complement_num not in", values, "needComplementNum");
            return (Criteria) this;
        }

        public Criteria andNeedComplementNumBetween(Integer value1, Integer value2) {
            addCriterion("need_complement_num between", value1, value2, "needComplementNum");
            return (Criteria) this;
        }

        public Criteria andNeedComplementNumNotBetween(Integer value1, Integer value2) {
            addCriterion("need_complement_num not between", value1, value2, "needComplementNum");
            return (Criteria) this;
        }

        public Criteria andComplementSendTimeIsNull() {
            addCriterion("complement_send_time is null");
            return (Criteria) this;
        }

        public Criteria andComplementSendTimeIsNotNull() {
            addCriterion("complement_send_time is not null");
            return (Criteria) this;
        }

        public Criteria andComplementSendTimeEqualTo(Date value) {
            addCriterion("complement_send_time =", value, "complementSendTime");
            return (Criteria) this;
        }

        public Criteria andComplementSendTimeNotEqualTo(Date value) {
            addCriterion("complement_send_time <>", value, "complementSendTime");
            return (Criteria) this;
        }

        public Criteria andComplementSendTimeGreaterThan(Date value) {
            addCriterion("complement_send_time >", value, "complementSendTime");
            return (Criteria) this;
        }

        public Criteria andComplementSendTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("complement_send_time >=", value, "complementSendTime");
            return (Criteria) this;
        }

        public Criteria andComplementSendTimeLessThan(Date value) {
            addCriterion("complement_send_time <", value, "complementSendTime");
            return (Criteria) this;
        }

        public Criteria andComplementSendTimeLessThanOrEqualTo(Date value) {
            addCriterion("complement_send_time <=", value, "complementSendTime");
            return (Criteria) this;
        }

        public Criteria andComplementSendTimeIn(List<Date> values) {
            addCriterion("complement_send_time in", values, "complementSendTime");
            return (Criteria) this;
        }

        public Criteria andComplementSendTimeNotIn(List<Date> values) {
            addCriterion("complement_send_time not in", values, "complementSendTime");
            return (Criteria) this;
        }

        public Criteria andComplementSendTimeBetween(Date value1, Date value2) {
            addCriterion("complement_send_time between", value1, value2, "complementSendTime");
            return (Criteria) this;
        }

        public Criteria andComplementSendTimeNotBetween(Date value1, Date value2) {
            addCriterion("complement_send_time not between", value1, value2, "complementSendTime");
            return (Criteria) this;
        }

        public Criteria andComplementSendTypeIsNull() {
            addCriterion("complement_send_type is null");
            return (Criteria) this;
        }

        public Criteria andComplementSendTypeIsNotNull() {
            addCriterion("complement_send_type is not null");
            return (Criteria) this;
        }

        public Criteria andComplementSendTypeEqualTo(Integer value) {
            addCriterion("complement_send_type =", value, "complementSendType");
            return (Criteria) this;
        }

        public Criteria andComplementSendTypeNotEqualTo(Integer value) {
            addCriterion("complement_send_type <>", value, "complementSendType");
            return (Criteria) this;
        }

        public Criteria andComplementSendTypeGreaterThan(Integer value) {
            addCriterion("complement_send_type >", value, "complementSendType");
            return (Criteria) this;
        }

        public Criteria andComplementSendTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("complement_send_type >=", value, "complementSendType");
            return (Criteria) this;
        }

        public Criteria andComplementSendTypeLessThan(Integer value) {
            addCriterion("complement_send_type <", value, "complementSendType");
            return (Criteria) this;
        }

        public Criteria andComplementSendTypeLessThanOrEqualTo(Integer value) {
            addCriterion("complement_send_type <=", value, "complementSendType");
            return (Criteria) this;
        }

        public Criteria andComplementSendTypeIn(List<Integer> values) {
            addCriterion("complement_send_type in", values, "complementSendType");
            return (Criteria) this;
        }

        public Criteria andComplementSendTypeNotIn(List<Integer> values) {
            addCriterion("complement_send_type not in", values, "complementSendType");
            return (Criteria) this;
        }

        public Criteria andComplementSendTypeBetween(Integer value1, Integer value2) {
            addCriterion("complement_send_type between", value1, value2, "complementSendType");
            return (Criteria) this;
        }

        public Criteria andComplementSendTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("complement_send_type not between", value1, value2, "complementSendType");
            return (Criteria) this;
        }

        public Criteria andOpIdIsNull() {
            addCriterion("op_id is null");
            return (Criteria) this;
        }

        public Criteria andOpIdIsNotNull() {
            addCriterion("op_id is not null");
            return (Criteria) this;
        }

        public Criteria andOpIdEqualTo(String value) {
            addCriterion("op_id =", value, "opId");
            return (Criteria) this;
        }

        public Criteria andOpIdNotEqualTo(String value) {
            addCriterion("op_id <>", value, "opId");
            return (Criteria) this;
        }

        public Criteria andOpIdGreaterThan(String value) {
            addCriterion("op_id >", value, "opId");
            return (Criteria) this;
        }

        public Criteria andOpIdGreaterThanOrEqualTo(String value) {
            addCriterion("op_id >=", value, "opId");
            return (Criteria) this;
        }

        public Criteria andOpIdLessThan(String value) {
            addCriterion("op_id <", value, "opId");
            return (Criteria) this;
        }

        public Criteria andOpIdLessThanOrEqualTo(String value) {
            addCriterion("op_id <=", value, "opId");
            return (Criteria) this;
        }

        public Criteria andOpIdLike(String value) {
            addCriterion("op_id like", value, "opId");
            return (Criteria) this;
        }

        public Criteria andOpIdNotLike(String value) {
            addCriterion("op_id not like", value, "opId");
            return (Criteria) this;
        }

        public Criteria andOpIdIn(List<String> values) {
            addCriterion("op_id in", values, "opId");
            return (Criteria) this;
        }

        public Criteria andOpIdNotIn(List<String> values) {
            addCriterion("op_id not in", values, "opId");
            return (Criteria) this;
        }

        public Criteria andOpIdBetween(String value1, String value2) {
            addCriterion("op_id between", value1, value2, "opId");
            return (Criteria) this;
        }

        public Criteria andOpIdNotBetween(String value1, String value2) {
            addCriterion("op_id not between", value1, value2, "opId");
            return (Criteria) this;
        }

        public Criteria andGiftIsNull() {
            addCriterion("gift is null");
            return (Criteria) this;
        }

        public Criteria andGiftIsNotNull() {
            addCriterion("gift is not null");
            return (Criteria) this;
        }

        public Criteria andGiftEqualTo(Integer value) {
            addCriterion("gift =", value, "gift");
            return (Criteria) this;
        }

        public Criteria andGiftNotEqualTo(Integer value) {
            addCriterion("gift <>", value, "gift");
            return (Criteria) this;
        }

        public Criteria andGiftGreaterThan(Integer value) {
            addCriterion("gift >", value, "gift");
            return (Criteria) this;
        }

        public Criteria andGiftGreaterThanOrEqualTo(Integer value) {
            addCriterion("gift >=", value, "gift");
            return (Criteria) this;
        }

        public Criteria andGiftLessThan(Integer value) {
            addCriterion("gift <", value, "gift");
            return (Criteria) this;
        }

        public Criteria andGiftLessThanOrEqualTo(Integer value) {
            addCriterion("gift <=", value, "gift");
            return (Criteria) this;
        }

        public Criteria andGiftIn(List<Integer> values) {
            addCriterion("gift in", values, "gift");
            return (Criteria) this;
        }

        public Criteria andGiftNotIn(List<Integer> values) {
            addCriterion("gift not in", values, "gift");
            return (Criteria) this;
        }

        public Criteria andGiftBetween(Integer value1, Integer value2) {
            addCriterion("gift between", value1, value2, "gift");
            return (Criteria) this;
        }

        public Criteria andGiftNotBetween(Integer value1, Integer value2) {
            addCriterion("gift not between", value1, value2, "gift");
            return (Criteria) this;
        }

        public Criteria andLastModifiedDateIsNull() {
            addCriterion("last_modified_date is null");
            return (Criteria) this;
        }

        public Criteria andLastModifiedDateIsNotNull() {
            addCriterion("last_modified_date is not null");
            return (Criteria) this;
        }

        public Criteria andLastModifiedDateEqualTo(Date value) {
            addCriterion("last_modified_date =", value, "lastModifiedDate");
            return (Criteria) this;
        }

        public Criteria andLastModifiedDateNotEqualTo(Date value) {
            addCriterion("last_modified_date <>", value, "lastModifiedDate");
            return (Criteria) this;
        }

        public Criteria andLastModifiedDateGreaterThan(Date value) {
            addCriterion("last_modified_date >", value, "lastModifiedDate");
            return (Criteria) this;
        }

        public Criteria andLastModifiedDateGreaterThanOrEqualTo(Date value) {
            addCriterion("last_modified_date >=", value, "lastModifiedDate");
            return (Criteria) this;
        }

        public Criteria andLastModifiedDateLessThan(Date value) {
            addCriterion("last_modified_date <", value, "lastModifiedDate");
            return (Criteria) this;
        }

        public Criteria andLastModifiedDateLessThanOrEqualTo(Date value) {
            addCriterion("last_modified_date <=", value, "lastModifiedDate");
            return (Criteria) this;
        }

        public Criteria andLastModifiedDateIn(List<Date> values) {
            addCriterion("last_modified_date in", values, "lastModifiedDate");
            return (Criteria) this;
        }

        public Criteria andLastModifiedDateNotIn(List<Date> values) {
            addCriterion("last_modified_date not in", values, "lastModifiedDate");
            return (Criteria) this;
        }

        public Criteria andLastModifiedDateBetween(Date value1, Date value2) {
            addCriterion("last_modified_date between", value1, value2, "lastModifiedDate");
            return (Criteria) this;
        }

        public Criteria andLastModifiedDateNotBetween(Date value1, Date value2) {
            addCriterion("last_modified_date not between", value1, value2, "lastModifiedDate");
            return (Criteria) this;
        }

        public Criteria andAddSnIsNull() {
            addCriterion("add_sn is null");
            return (Criteria) this;
        }

        public Criteria andAddSnIsNotNull() {
            addCriterion("add_sn is not null");
            return (Criteria) this;
        }

        public Criteria andAddSnEqualTo(Integer value) {
            addCriterion("add_sn =", value, "addSn");
            return (Criteria) this;
        }

        public Criteria andAddSnNotEqualTo(Integer value) {
            addCriterion("add_sn <>", value, "addSn");
            return (Criteria) this;
        }

        public Criteria andAddSnGreaterThan(Integer value) {
            addCriterion("add_sn >", value, "addSn");
            return (Criteria) this;
        }

        public Criteria andAddSnGreaterThanOrEqualTo(Integer value) {
            addCriterion("add_sn >=", value, "addSn");
            return (Criteria) this;
        }

        public Criteria andAddSnLessThan(Integer value) {
            addCriterion("add_sn <", value, "addSn");
            return (Criteria) this;
        }

        public Criteria andAddSnLessThanOrEqualTo(Integer value) {
            addCriterion("add_sn <=", value, "addSn");
            return (Criteria) this;
        }

        public Criteria andAddSnIn(List<Integer> values) {
            addCriterion("add_sn in", values, "addSn");
            return (Criteria) this;
        }

        public Criteria andAddSnNotIn(List<Integer> values) {
            addCriterion("add_sn not in", values, "addSn");
            return (Criteria) this;
        }

        public Criteria andAddSnBetween(Integer value1, Integer value2) {
            addCriterion("add_sn between", value1, value2, "addSn");
            return (Criteria) this;
        }

        public Criteria andAddSnNotBetween(Integer value1, Integer value2) {
            addCriterion("add_sn not between", value1, value2, "addSn");
            return (Criteria) this;
        }

        public Criteria andComplementNotifyTimesIsNull() {
            addCriterion("complement_notify_times is null");
            return (Criteria) this;
        }

        public Criteria andComplementNotifyTimesIsNotNull() {
            addCriterion("complement_notify_times is not null");
            return (Criteria) this;
        }

        public Criteria andComplementNotifyTimesEqualTo(Integer value) {
            addCriterion("complement_notify_times =", value, "complementNotifyTimes");
            return (Criteria) this;
        }

        public Criteria andComplementNotifyTimesNotEqualTo(Integer value) {
            addCriterion("complement_notify_times <>", value, "complementNotifyTimes");
            return (Criteria) this;
        }

        public Criteria andComplementNotifyTimesGreaterThan(Integer value) {
            addCriterion("complement_notify_times >", value, "complementNotifyTimes");
            return (Criteria) this;
        }

        public Criteria andComplementNotifyTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("complement_notify_times >=", value, "complementNotifyTimes");
            return (Criteria) this;
        }

        public Criteria andComplementNotifyTimesLessThan(Integer value) {
            addCriterion("complement_notify_times <", value, "complementNotifyTimes");
            return (Criteria) this;
        }

        public Criteria andComplementNotifyTimesLessThanOrEqualTo(Integer value) {
            addCriterion("complement_notify_times <=", value, "complementNotifyTimes");
            return (Criteria) this;
        }

        public Criteria andComplementNotifyTimesIn(List<Integer> values) {
            addCriterion("complement_notify_times in", values, "complementNotifyTimes");
            return (Criteria) this;
        }

        public Criteria andComplementNotifyTimesNotIn(List<Integer> values) {
            addCriterion("complement_notify_times not in", values, "complementNotifyTimes");
            return (Criteria) this;
        }

        public Criteria andComplementNotifyTimesBetween(Integer value1, Integer value2) {
            addCriterion("complement_notify_times between", value1, value2, "complementNotifyTimes");
            return (Criteria) this;
        }

        public Criteria andComplementNotifyTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("complement_notify_times not between", value1, value2, "complementNotifyTimes");
            return (Criteria) this;
        }

        public Criteria andCaseExamineIsNull() {
            addCriterion("case_examine is null");
            return (Criteria) this;
        }

        public Criteria andCaseExamineIsNotNull() {
            addCriterion("case_examine is not null");
            return (Criteria) this;
        }

        public Criteria andCaseExamineEqualTo(Integer value) {
            addCriterion("case_examine =", value, "caseExamine");
            return (Criteria) this;
        }

        public Criteria andCaseExamineNotEqualTo(Integer value) {
            addCriterion("case_examine <>", value, "caseExamine");
            return (Criteria) this;
        }

        public Criteria andCaseExamineGreaterThan(Integer value) {
            addCriterion("case_examine >", value, "caseExamine");
            return (Criteria) this;
        }

        public Criteria andCaseExamineGreaterThanOrEqualTo(Integer value) {
            addCriterion("case_examine >=", value, "caseExamine");
            return (Criteria) this;
        }

        public Criteria andCaseExamineLessThan(Integer value) {
            addCriterion("case_examine <", value, "caseExamine");
            return (Criteria) this;
        }

        public Criteria andCaseExamineLessThanOrEqualTo(Integer value) {
            addCriterion("case_examine <=", value, "caseExamine");
            return (Criteria) this;
        }

        public Criteria andCaseExamineIn(List<Integer> values) {
            addCriterion("case_examine in", values, "caseExamine");
            return (Criteria) this;
        }

        public Criteria andCaseExamineNotIn(List<Integer> values) {
            addCriterion("case_examine not in", values, "caseExamine");
            return (Criteria) this;
        }

        public Criteria andCaseExamineBetween(Integer value1, Integer value2) {
            addCriterion("case_examine between", value1, value2, "caseExamine");
            return (Criteria) this;
        }

        public Criteria andCaseExamineNotBetween(Integer value1, Integer value2) {
            addCriterion("case_examine not between", value1, value2, "caseExamine");
            return (Criteria) this;
        }

        public Criteria andCaseObsoleteIsNull() {
            addCriterion("case_obsolete is null");
            return (Criteria) this;
        }

        public Criteria andCaseObsoleteIsNotNull() {
            addCriterion("case_obsolete is not null");
            return (Criteria) this;
        }

        public Criteria andCaseObsoleteEqualTo(Integer value) {
            addCriterion("case_obsolete =", value, "caseObsolete");
            return (Criteria) this;
        }

        public Criteria andCaseObsoleteNotEqualTo(Integer value) {
            addCriterion("case_obsolete <>", value, "caseObsolete");
            return (Criteria) this;
        }

        public Criteria andCaseObsoleteGreaterThan(Integer value) {
            addCriterion("case_obsolete >", value, "caseObsolete");
            return (Criteria) this;
        }

        public Criteria andCaseObsoleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("case_obsolete >=", value, "caseObsolete");
            return (Criteria) this;
        }

        public Criteria andCaseObsoleteLessThan(Integer value) {
            addCriterion("case_obsolete <", value, "caseObsolete");
            return (Criteria) this;
        }

        public Criteria andCaseObsoleteLessThanOrEqualTo(Integer value) {
            addCriterion("case_obsolete <=", value, "caseObsolete");
            return (Criteria) this;
        }

        public Criteria andCaseObsoleteIn(List<Integer> values) {
            addCriterion("case_obsolete in", values, "caseObsolete");
            return (Criteria) this;
        }

        public Criteria andCaseObsoleteNotIn(List<Integer> values) {
            addCriterion("case_obsolete not in", values, "caseObsolete");
            return (Criteria) this;
        }

        public Criteria andCaseObsoleteBetween(Integer value1, Integer value2) {
            addCriterion("case_obsolete between", value1, value2, "caseObsolete");
            return (Criteria) this;
        }

        public Criteria andCaseObsoleteNotBetween(Integer value1, Integer value2) {
            addCriterion("case_obsolete not between", value1, value2, "caseObsolete");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}