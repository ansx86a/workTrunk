package model;

import java.util.ArrayList;
import java.util.List;

public class TerritoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TerritoryExample() {
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

        public Criteria andTerritoryidIsNull() {
            addCriterion("TerritoryID is null");
            return (Criteria) this;
        }

        public Criteria andTerritoryidIsNotNull() {
            addCriterion("TerritoryID is not null");
            return (Criteria) this;
        }

        public Criteria andTerritoryidEqualTo(String value) {
            addCriterion("TerritoryID =", value, "territoryid");
            return (Criteria) this;
        }

        public Criteria andTerritoryidNotEqualTo(String value) {
            addCriterion("TerritoryID <>", value, "territoryid");
            return (Criteria) this;
        }

        public Criteria andTerritoryidGreaterThan(String value) {
            addCriterion("TerritoryID >", value, "territoryid");
            return (Criteria) this;
        }

        public Criteria andTerritoryidGreaterThanOrEqualTo(String value) {
            addCriterion("TerritoryID >=", value, "territoryid");
            return (Criteria) this;
        }

        public Criteria andTerritoryidLessThan(String value) {
            addCriterion("TerritoryID <", value, "territoryid");
            return (Criteria) this;
        }

        public Criteria andTerritoryidLessThanOrEqualTo(String value) {
            addCriterion("TerritoryID <=", value, "territoryid");
            return (Criteria) this;
        }

        public Criteria andTerritoryidLike(String value) {
            addCriterion("TerritoryID like", value, "territoryid");
            return (Criteria) this;
        }

        public Criteria andTerritoryidNotLike(String value) {
            addCriterion("TerritoryID not like", value, "territoryid");
            return (Criteria) this;
        }

        public Criteria andTerritoryidIn(List<String> values) {
            addCriterion("TerritoryID in", values, "territoryid");
            return (Criteria) this;
        }

        public Criteria andTerritoryidNotIn(List<String> values) {
            addCriterion("TerritoryID not in", values, "territoryid");
            return (Criteria) this;
        }

        public Criteria andTerritoryidBetween(String value1, String value2) {
            addCriterion("TerritoryID between", value1, value2, "territoryid");
            return (Criteria) this;
        }

        public Criteria andTerritoryidNotBetween(String value1, String value2) {
            addCriterion("TerritoryID not between", value1, value2, "territoryid");
            return (Criteria) this;
        }

        public Criteria andTerritorydescriptionIsNull() {
            addCriterion("TerritoryDescription is null");
            return (Criteria) this;
        }

        public Criteria andTerritorydescriptionIsNotNull() {
            addCriterion("TerritoryDescription is not null");
            return (Criteria) this;
        }

        public Criteria andTerritorydescriptionEqualTo(String value) {
            addCriterion("TerritoryDescription =", value, "territorydescription");
            return (Criteria) this;
        }

        public Criteria andTerritorydescriptionNotEqualTo(String value) {
            addCriterion("TerritoryDescription <>", value, "territorydescription");
            return (Criteria) this;
        }

        public Criteria andTerritorydescriptionGreaterThan(String value) {
            addCriterion("TerritoryDescription >", value, "territorydescription");
            return (Criteria) this;
        }

        public Criteria andTerritorydescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("TerritoryDescription >=", value, "territorydescription");
            return (Criteria) this;
        }

        public Criteria andTerritorydescriptionLessThan(String value) {
            addCriterion("TerritoryDescription <", value, "territorydescription");
            return (Criteria) this;
        }

        public Criteria andTerritorydescriptionLessThanOrEqualTo(String value) {
            addCriterion("TerritoryDescription <=", value, "territorydescription");
            return (Criteria) this;
        }

        public Criteria andTerritorydescriptionLike(String value) {
            addCriterion("TerritoryDescription like", value, "territorydescription");
            return (Criteria) this;
        }

        public Criteria andTerritorydescriptionNotLike(String value) {
            addCriterion("TerritoryDescription not like", value, "territorydescription");
            return (Criteria) this;
        }

        public Criteria andTerritorydescriptionIn(List<String> values) {
            addCriterion("TerritoryDescription in", values, "territorydescription");
            return (Criteria) this;
        }

        public Criteria andTerritorydescriptionNotIn(List<String> values) {
            addCriterion("TerritoryDescription not in", values, "territorydescription");
            return (Criteria) this;
        }

        public Criteria andTerritorydescriptionBetween(String value1, String value2) {
            addCriterion("TerritoryDescription between", value1, value2, "territorydescription");
            return (Criteria) this;
        }

        public Criteria andTerritorydescriptionNotBetween(String value1, String value2) {
            addCriterion("TerritoryDescription not between", value1, value2, "territorydescription");
            return (Criteria) this;
        }

        public Criteria andRegionidIsNull() {
            addCriterion("RegionID is null");
            return (Criteria) this;
        }

        public Criteria andRegionidIsNotNull() {
            addCriterion("RegionID is not null");
            return (Criteria) this;
        }

        public Criteria andRegionidEqualTo(Integer value) {
            addCriterion("RegionID =", value, "regionid");
            return (Criteria) this;
        }

        public Criteria andRegionidNotEqualTo(Integer value) {
            addCriterion("RegionID <>", value, "regionid");
            return (Criteria) this;
        }

        public Criteria andRegionidGreaterThan(Integer value) {
            addCriterion("RegionID >", value, "regionid");
            return (Criteria) this;
        }

        public Criteria andRegionidGreaterThanOrEqualTo(Integer value) {
            addCriterion("RegionID >=", value, "regionid");
            return (Criteria) this;
        }

        public Criteria andRegionidLessThan(Integer value) {
            addCriterion("RegionID <", value, "regionid");
            return (Criteria) this;
        }

        public Criteria andRegionidLessThanOrEqualTo(Integer value) {
            addCriterion("RegionID <=", value, "regionid");
            return (Criteria) this;
        }

        public Criteria andRegionidIn(List<Integer> values) {
            addCriterion("RegionID in", values, "regionid");
            return (Criteria) this;
        }

        public Criteria andRegionidNotIn(List<Integer> values) {
            addCriterion("RegionID not in", values, "regionid");
            return (Criteria) this;
        }

        public Criteria andRegionidBetween(Integer value1, Integer value2) {
            addCriterion("RegionID between", value1, value2, "regionid");
            return (Criteria) this;
        }

        public Criteria andRegionidNotBetween(Integer value1, Integer value2) {
            addCriterion("RegionID not between", value1, value2, "regionid");
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