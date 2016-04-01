package model;

import java.util.ArrayList;
import java.util.List;

public class CustomerDemographicExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CustomerDemographicExample() {
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

        public Criteria andCustomertypeidIsNull() {
            addCriterion("CustomerTypeID is null");
            return (Criteria) this;
        }

        public Criteria andCustomertypeidIsNotNull() {
            addCriterion("CustomerTypeID is not null");
            return (Criteria) this;
        }

        public Criteria andCustomertypeidEqualTo(String value) {
            addCriterion("CustomerTypeID =", value, "customertypeid");
            return (Criteria) this;
        }

        public Criteria andCustomertypeidNotEqualTo(String value) {
            addCriterion("CustomerTypeID <>", value, "customertypeid");
            return (Criteria) this;
        }

        public Criteria andCustomertypeidGreaterThan(String value) {
            addCriterion("CustomerTypeID >", value, "customertypeid");
            return (Criteria) this;
        }

        public Criteria andCustomertypeidGreaterThanOrEqualTo(String value) {
            addCriterion("CustomerTypeID >=", value, "customertypeid");
            return (Criteria) this;
        }

        public Criteria andCustomertypeidLessThan(String value) {
            addCriterion("CustomerTypeID <", value, "customertypeid");
            return (Criteria) this;
        }

        public Criteria andCustomertypeidLessThanOrEqualTo(String value) {
            addCriterion("CustomerTypeID <=", value, "customertypeid");
            return (Criteria) this;
        }

        public Criteria andCustomertypeidLike(String value) {
            addCriterion("CustomerTypeID like", value, "customertypeid");
            return (Criteria) this;
        }

        public Criteria andCustomertypeidNotLike(String value) {
            addCriterion("CustomerTypeID not like", value, "customertypeid");
            return (Criteria) this;
        }

        public Criteria andCustomertypeidIn(List<String> values) {
            addCriterion("CustomerTypeID in", values, "customertypeid");
            return (Criteria) this;
        }

        public Criteria andCustomertypeidNotIn(List<String> values) {
            addCriterion("CustomerTypeID not in", values, "customertypeid");
            return (Criteria) this;
        }

        public Criteria andCustomertypeidBetween(String value1, String value2) {
            addCriterion("CustomerTypeID between", value1, value2, "customertypeid");
            return (Criteria) this;
        }

        public Criteria andCustomertypeidNotBetween(String value1, String value2) {
            addCriterion("CustomerTypeID not between", value1, value2, "customertypeid");
            return (Criteria) this;
        }

        public Criteria andCustomerdescIsNull() {
            addCriterion("CustomerDesc is null");
            return (Criteria) this;
        }

        public Criteria andCustomerdescIsNotNull() {
            addCriterion("CustomerDesc is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerdescEqualTo(String value) {
            addCriterion("CustomerDesc =", value, "customerdesc");
            return (Criteria) this;
        }

        public Criteria andCustomerdescNotEqualTo(String value) {
            addCriterion("CustomerDesc <>", value, "customerdesc");
            return (Criteria) this;
        }

        public Criteria andCustomerdescGreaterThan(String value) {
            addCriterion("CustomerDesc >", value, "customerdesc");
            return (Criteria) this;
        }

        public Criteria andCustomerdescGreaterThanOrEqualTo(String value) {
            addCriterion("CustomerDesc >=", value, "customerdesc");
            return (Criteria) this;
        }

        public Criteria andCustomerdescLessThan(String value) {
            addCriterion("CustomerDesc <", value, "customerdesc");
            return (Criteria) this;
        }

        public Criteria andCustomerdescLessThanOrEqualTo(String value) {
            addCriterion("CustomerDesc <=", value, "customerdesc");
            return (Criteria) this;
        }

        public Criteria andCustomerdescLike(String value) {
            addCriterion("CustomerDesc like", value, "customerdesc");
            return (Criteria) this;
        }

        public Criteria andCustomerdescNotLike(String value) {
            addCriterion("CustomerDesc not like", value, "customerdesc");
            return (Criteria) this;
        }

        public Criteria andCustomerdescIn(List<String> values) {
            addCriterion("CustomerDesc in", values, "customerdesc");
            return (Criteria) this;
        }

        public Criteria andCustomerdescNotIn(List<String> values) {
            addCriterion("CustomerDesc not in", values, "customerdesc");
            return (Criteria) this;
        }

        public Criteria andCustomerdescBetween(String value1, String value2) {
            addCriterion("CustomerDesc between", value1, value2, "customerdesc");
            return (Criteria) this;
        }

        public Criteria andCustomerdescNotBetween(String value1, String value2) {
            addCriterion("CustomerDesc not between", value1, value2, "customerdesc");
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