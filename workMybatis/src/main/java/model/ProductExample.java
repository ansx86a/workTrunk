package model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductExample() {
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

        public Criteria andProductidIsNull() {
            addCriterion("ProductID is null");
            return (Criteria) this;
        }

        public Criteria andProductidIsNotNull() {
            addCriterion("ProductID is not null");
            return (Criteria) this;
        }

        public Criteria andProductidEqualTo(Integer value) {
            addCriterion("ProductID =", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidNotEqualTo(Integer value) {
            addCriterion("ProductID <>", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidGreaterThan(Integer value) {
            addCriterion("ProductID >", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ProductID >=", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidLessThan(Integer value) {
            addCriterion("ProductID <", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidLessThanOrEqualTo(Integer value) {
            addCriterion("ProductID <=", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidIn(List<Integer> values) {
            addCriterion("ProductID in", values, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidNotIn(List<Integer> values) {
            addCriterion("ProductID not in", values, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidBetween(Integer value1, Integer value2) {
            addCriterion("ProductID between", value1, value2, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidNotBetween(Integer value1, Integer value2) {
            addCriterion("ProductID not between", value1, value2, "productid");
            return (Criteria) this;
        }

        public Criteria andProductnameIsNull() {
            addCriterion("ProductName is null");
            return (Criteria) this;
        }

        public Criteria andProductnameIsNotNull() {
            addCriterion("ProductName is not null");
            return (Criteria) this;
        }

        public Criteria andProductnameEqualTo(String value) {
            addCriterion("ProductName =", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotEqualTo(String value) {
            addCriterion("ProductName <>", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameGreaterThan(String value) {
            addCriterion("ProductName >", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameGreaterThanOrEqualTo(String value) {
            addCriterion("ProductName >=", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameLessThan(String value) {
            addCriterion("ProductName <", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameLessThanOrEqualTo(String value) {
            addCriterion("ProductName <=", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameLike(String value) {
            addCriterion("ProductName like", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotLike(String value) {
            addCriterion("ProductName not like", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameIn(List<String> values) {
            addCriterion("ProductName in", values, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotIn(List<String> values) {
            addCriterion("ProductName not in", values, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameBetween(String value1, String value2) {
            addCriterion("ProductName between", value1, value2, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotBetween(String value1, String value2) {
            addCriterion("ProductName not between", value1, value2, "productname");
            return (Criteria) this;
        }

        public Criteria andSupplieridIsNull() {
            addCriterion("SupplierID is null");
            return (Criteria) this;
        }

        public Criteria andSupplieridIsNotNull() {
            addCriterion("SupplierID is not null");
            return (Criteria) this;
        }

        public Criteria andSupplieridEqualTo(Integer value) {
            addCriterion("SupplierID =", value, "supplierid");
            return (Criteria) this;
        }

        public Criteria andSupplieridNotEqualTo(Integer value) {
            addCriterion("SupplierID <>", value, "supplierid");
            return (Criteria) this;
        }

        public Criteria andSupplieridGreaterThan(Integer value) {
            addCriterion("SupplierID >", value, "supplierid");
            return (Criteria) this;
        }

        public Criteria andSupplieridGreaterThanOrEqualTo(Integer value) {
            addCriterion("SupplierID >=", value, "supplierid");
            return (Criteria) this;
        }

        public Criteria andSupplieridLessThan(Integer value) {
            addCriterion("SupplierID <", value, "supplierid");
            return (Criteria) this;
        }

        public Criteria andSupplieridLessThanOrEqualTo(Integer value) {
            addCriterion("SupplierID <=", value, "supplierid");
            return (Criteria) this;
        }

        public Criteria andSupplieridIn(List<Integer> values) {
            addCriterion("SupplierID in", values, "supplierid");
            return (Criteria) this;
        }

        public Criteria andSupplieridNotIn(List<Integer> values) {
            addCriterion("SupplierID not in", values, "supplierid");
            return (Criteria) this;
        }

        public Criteria andSupplieridBetween(Integer value1, Integer value2) {
            addCriterion("SupplierID between", value1, value2, "supplierid");
            return (Criteria) this;
        }

        public Criteria andSupplieridNotBetween(Integer value1, Integer value2) {
            addCriterion("SupplierID not between", value1, value2, "supplierid");
            return (Criteria) this;
        }

        public Criteria andCategoryidIsNull() {
            addCriterion("CategoryID is null");
            return (Criteria) this;
        }

        public Criteria andCategoryidIsNotNull() {
            addCriterion("CategoryID is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryidEqualTo(Integer value) {
            addCriterion("CategoryID =", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidNotEqualTo(Integer value) {
            addCriterion("CategoryID <>", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidGreaterThan(Integer value) {
            addCriterion("CategoryID >", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidGreaterThanOrEqualTo(Integer value) {
            addCriterion("CategoryID >=", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidLessThan(Integer value) {
            addCriterion("CategoryID <", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidLessThanOrEqualTo(Integer value) {
            addCriterion("CategoryID <=", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidIn(List<Integer> values) {
            addCriterion("CategoryID in", values, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidNotIn(List<Integer> values) {
            addCriterion("CategoryID not in", values, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidBetween(Integer value1, Integer value2) {
            addCriterion("CategoryID between", value1, value2, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidNotBetween(Integer value1, Integer value2) {
            addCriterion("CategoryID not between", value1, value2, "categoryid");
            return (Criteria) this;
        }

        public Criteria andQuantityperunitIsNull() {
            addCriterion("QuantityPerUnit is null");
            return (Criteria) this;
        }

        public Criteria andQuantityperunitIsNotNull() {
            addCriterion("QuantityPerUnit is not null");
            return (Criteria) this;
        }

        public Criteria andQuantityperunitEqualTo(String value) {
            addCriterion("QuantityPerUnit =", value, "quantityperunit");
            return (Criteria) this;
        }

        public Criteria andQuantityperunitNotEqualTo(String value) {
            addCriterion("QuantityPerUnit <>", value, "quantityperunit");
            return (Criteria) this;
        }

        public Criteria andQuantityperunitGreaterThan(String value) {
            addCriterion("QuantityPerUnit >", value, "quantityperunit");
            return (Criteria) this;
        }

        public Criteria andQuantityperunitGreaterThanOrEqualTo(String value) {
            addCriterion("QuantityPerUnit >=", value, "quantityperunit");
            return (Criteria) this;
        }

        public Criteria andQuantityperunitLessThan(String value) {
            addCriterion("QuantityPerUnit <", value, "quantityperunit");
            return (Criteria) this;
        }

        public Criteria andQuantityperunitLessThanOrEqualTo(String value) {
            addCriterion("QuantityPerUnit <=", value, "quantityperunit");
            return (Criteria) this;
        }

        public Criteria andQuantityperunitLike(String value) {
            addCriterion("QuantityPerUnit like", value, "quantityperunit");
            return (Criteria) this;
        }

        public Criteria andQuantityperunitNotLike(String value) {
            addCriterion("QuantityPerUnit not like", value, "quantityperunit");
            return (Criteria) this;
        }

        public Criteria andQuantityperunitIn(List<String> values) {
            addCriterion("QuantityPerUnit in", values, "quantityperunit");
            return (Criteria) this;
        }

        public Criteria andQuantityperunitNotIn(List<String> values) {
            addCriterion("QuantityPerUnit not in", values, "quantityperunit");
            return (Criteria) this;
        }

        public Criteria andQuantityperunitBetween(String value1, String value2) {
            addCriterion("QuantityPerUnit between", value1, value2, "quantityperunit");
            return (Criteria) this;
        }

        public Criteria andQuantityperunitNotBetween(String value1, String value2) {
            addCriterion("QuantityPerUnit not between", value1, value2, "quantityperunit");
            return (Criteria) this;
        }

        public Criteria andUnitpriceIsNull() {
            addCriterion("UnitPrice is null");
            return (Criteria) this;
        }

        public Criteria andUnitpriceIsNotNull() {
            addCriterion("UnitPrice is not null");
            return (Criteria) this;
        }

        public Criteria andUnitpriceEqualTo(BigDecimal value) {
            addCriterion("UnitPrice =", value, "unitprice");
            return (Criteria) this;
        }

        public Criteria andUnitpriceNotEqualTo(BigDecimal value) {
            addCriterion("UnitPrice <>", value, "unitprice");
            return (Criteria) this;
        }

        public Criteria andUnitpriceGreaterThan(BigDecimal value) {
            addCriterion("UnitPrice >", value, "unitprice");
            return (Criteria) this;
        }

        public Criteria andUnitpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("UnitPrice >=", value, "unitprice");
            return (Criteria) this;
        }

        public Criteria andUnitpriceLessThan(BigDecimal value) {
            addCriterion("UnitPrice <", value, "unitprice");
            return (Criteria) this;
        }

        public Criteria andUnitpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("UnitPrice <=", value, "unitprice");
            return (Criteria) this;
        }

        public Criteria andUnitpriceIn(List<BigDecimal> values) {
            addCriterion("UnitPrice in", values, "unitprice");
            return (Criteria) this;
        }

        public Criteria andUnitpriceNotIn(List<BigDecimal> values) {
            addCriterion("UnitPrice not in", values, "unitprice");
            return (Criteria) this;
        }

        public Criteria andUnitpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("UnitPrice between", value1, value2, "unitprice");
            return (Criteria) this;
        }

        public Criteria andUnitpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("UnitPrice not between", value1, value2, "unitprice");
            return (Criteria) this;
        }

        public Criteria andUnitsinstockIsNull() {
            addCriterion("UnitsInStock is null");
            return (Criteria) this;
        }

        public Criteria andUnitsinstockIsNotNull() {
            addCriterion("UnitsInStock is not null");
            return (Criteria) this;
        }

        public Criteria andUnitsinstockEqualTo(Short value) {
            addCriterion("UnitsInStock =", value, "unitsinstock");
            return (Criteria) this;
        }

        public Criteria andUnitsinstockNotEqualTo(Short value) {
            addCriterion("UnitsInStock <>", value, "unitsinstock");
            return (Criteria) this;
        }

        public Criteria andUnitsinstockGreaterThan(Short value) {
            addCriterion("UnitsInStock >", value, "unitsinstock");
            return (Criteria) this;
        }

        public Criteria andUnitsinstockGreaterThanOrEqualTo(Short value) {
            addCriterion("UnitsInStock >=", value, "unitsinstock");
            return (Criteria) this;
        }

        public Criteria andUnitsinstockLessThan(Short value) {
            addCriterion("UnitsInStock <", value, "unitsinstock");
            return (Criteria) this;
        }

        public Criteria andUnitsinstockLessThanOrEqualTo(Short value) {
            addCriterion("UnitsInStock <=", value, "unitsinstock");
            return (Criteria) this;
        }

        public Criteria andUnitsinstockIn(List<Short> values) {
            addCriterion("UnitsInStock in", values, "unitsinstock");
            return (Criteria) this;
        }

        public Criteria andUnitsinstockNotIn(List<Short> values) {
            addCriterion("UnitsInStock not in", values, "unitsinstock");
            return (Criteria) this;
        }

        public Criteria andUnitsinstockBetween(Short value1, Short value2) {
            addCriterion("UnitsInStock between", value1, value2, "unitsinstock");
            return (Criteria) this;
        }

        public Criteria andUnitsinstockNotBetween(Short value1, Short value2) {
            addCriterion("UnitsInStock not between", value1, value2, "unitsinstock");
            return (Criteria) this;
        }

        public Criteria andUnitsonorderIsNull() {
            addCriterion("UnitsOnOrder is null");
            return (Criteria) this;
        }

        public Criteria andUnitsonorderIsNotNull() {
            addCriterion("UnitsOnOrder is not null");
            return (Criteria) this;
        }

        public Criteria andUnitsonorderEqualTo(Short value) {
            addCriterion("UnitsOnOrder =", value, "unitsonorder");
            return (Criteria) this;
        }

        public Criteria andUnitsonorderNotEqualTo(Short value) {
            addCriterion("UnitsOnOrder <>", value, "unitsonorder");
            return (Criteria) this;
        }

        public Criteria andUnitsonorderGreaterThan(Short value) {
            addCriterion("UnitsOnOrder >", value, "unitsonorder");
            return (Criteria) this;
        }

        public Criteria andUnitsonorderGreaterThanOrEqualTo(Short value) {
            addCriterion("UnitsOnOrder >=", value, "unitsonorder");
            return (Criteria) this;
        }

        public Criteria andUnitsonorderLessThan(Short value) {
            addCriterion("UnitsOnOrder <", value, "unitsonorder");
            return (Criteria) this;
        }

        public Criteria andUnitsonorderLessThanOrEqualTo(Short value) {
            addCriterion("UnitsOnOrder <=", value, "unitsonorder");
            return (Criteria) this;
        }

        public Criteria andUnitsonorderIn(List<Short> values) {
            addCriterion("UnitsOnOrder in", values, "unitsonorder");
            return (Criteria) this;
        }

        public Criteria andUnitsonorderNotIn(List<Short> values) {
            addCriterion("UnitsOnOrder not in", values, "unitsonorder");
            return (Criteria) this;
        }

        public Criteria andUnitsonorderBetween(Short value1, Short value2) {
            addCriterion("UnitsOnOrder between", value1, value2, "unitsonorder");
            return (Criteria) this;
        }

        public Criteria andUnitsonorderNotBetween(Short value1, Short value2) {
            addCriterion("UnitsOnOrder not between", value1, value2, "unitsonorder");
            return (Criteria) this;
        }

        public Criteria andReorderlevelIsNull() {
            addCriterion("ReorderLevel is null");
            return (Criteria) this;
        }

        public Criteria andReorderlevelIsNotNull() {
            addCriterion("ReorderLevel is not null");
            return (Criteria) this;
        }

        public Criteria andReorderlevelEqualTo(Short value) {
            addCriterion("ReorderLevel =", value, "reorderlevel");
            return (Criteria) this;
        }

        public Criteria andReorderlevelNotEqualTo(Short value) {
            addCriterion("ReorderLevel <>", value, "reorderlevel");
            return (Criteria) this;
        }

        public Criteria andReorderlevelGreaterThan(Short value) {
            addCriterion("ReorderLevel >", value, "reorderlevel");
            return (Criteria) this;
        }

        public Criteria andReorderlevelGreaterThanOrEqualTo(Short value) {
            addCriterion("ReorderLevel >=", value, "reorderlevel");
            return (Criteria) this;
        }

        public Criteria andReorderlevelLessThan(Short value) {
            addCriterion("ReorderLevel <", value, "reorderlevel");
            return (Criteria) this;
        }

        public Criteria andReorderlevelLessThanOrEqualTo(Short value) {
            addCriterion("ReorderLevel <=", value, "reorderlevel");
            return (Criteria) this;
        }

        public Criteria andReorderlevelIn(List<Short> values) {
            addCriterion("ReorderLevel in", values, "reorderlevel");
            return (Criteria) this;
        }

        public Criteria andReorderlevelNotIn(List<Short> values) {
            addCriterion("ReorderLevel not in", values, "reorderlevel");
            return (Criteria) this;
        }

        public Criteria andReorderlevelBetween(Short value1, Short value2) {
            addCriterion("ReorderLevel between", value1, value2, "reorderlevel");
            return (Criteria) this;
        }

        public Criteria andReorderlevelNotBetween(Short value1, Short value2) {
            addCriterion("ReorderLevel not between", value1, value2, "reorderlevel");
            return (Criteria) this;
        }

        public Criteria andDiscontinuedIsNull() {
            addCriterion("Discontinued is null");
            return (Criteria) this;
        }

        public Criteria andDiscontinuedIsNotNull() {
            addCriterion("Discontinued is not null");
            return (Criteria) this;
        }

        public Criteria andDiscontinuedEqualTo(Boolean value) {
            addCriterion("Discontinued =", value, "discontinued");
            return (Criteria) this;
        }

        public Criteria andDiscontinuedNotEqualTo(Boolean value) {
            addCriterion("Discontinued <>", value, "discontinued");
            return (Criteria) this;
        }

        public Criteria andDiscontinuedGreaterThan(Boolean value) {
            addCriterion("Discontinued >", value, "discontinued");
            return (Criteria) this;
        }

        public Criteria andDiscontinuedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("Discontinued >=", value, "discontinued");
            return (Criteria) this;
        }

        public Criteria andDiscontinuedLessThan(Boolean value) {
            addCriterion("Discontinued <", value, "discontinued");
            return (Criteria) this;
        }

        public Criteria andDiscontinuedLessThanOrEqualTo(Boolean value) {
            addCriterion("Discontinued <=", value, "discontinued");
            return (Criteria) this;
        }

        public Criteria andDiscontinuedIn(List<Boolean> values) {
            addCriterion("Discontinued in", values, "discontinued");
            return (Criteria) this;
        }

        public Criteria andDiscontinuedNotIn(List<Boolean> values) {
            addCriterion("Discontinued not in", values, "discontinued");
            return (Criteria) this;
        }

        public Criteria andDiscontinuedBetween(Boolean value1, Boolean value2) {
            addCriterion("Discontinued between", value1, value2, "discontinued");
            return (Criteria) this;
        }

        public Criteria andDiscontinuedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("Discontinued not between", value1, value2, "discontinued");
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