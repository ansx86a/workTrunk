package model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExample() {
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

        public Criteria andOrderidIsNull() {
            addCriterion("OrderID is null");
            return (Criteria) this;
        }

        public Criteria andOrderidIsNotNull() {
            addCriterion("OrderID is not null");
            return (Criteria) this;
        }

        public Criteria andOrderidEqualTo(Integer value) {
            addCriterion("OrderID =", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotEqualTo(Integer value) {
            addCriterion("OrderID <>", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThan(Integer value) {
            addCriterion("OrderID >", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThanOrEqualTo(Integer value) {
            addCriterion("OrderID >=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThan(Integer value) {
            addCriterion("OrderID <", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThanOrEqualTo(Integer value) {
            addCriterion("OrderID <=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidIn(List<Integer> values) {
            addCriterion("OrderID in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotIn(List<Integer> values) {
            addCriterion("OrderID not in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidBetween(Integer value1, Integer value2) {
            addCriterion("OrderID between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotBetween(Integer value1, Integer value2) {
            addCriterion("OrderID not between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andCustomeridIsNull() {
            addCriterion("CustomerID is null");
            return (Criteria) this;
        }

        public Criteria andCustomeridIsNotNull() {
            addCriterion("CustomerID is not null");
            return (Criteria) this;
        }

        public Criteria andCustomeridEqualTo(String value) {
            addCriterion("CustomerID =", value, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridNotEqualTo(String value) {
            addCriterion("CustomerID <>", value, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridGreaterThan(String value) {
            addCriterion("CustomerID >", value, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridGreaterThanOrEqualTo(String value) {
            addCriterion("CustomerID >=", value, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridLessThan(String value) {
            addCriterion("CustomerID <", value, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridLessThanOrEqualTo(String value) {
            addCriterion("CustomerID <=", value, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridLike(String value) {
            addCriterion("CustomerID like", value, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridNotLike(String value) {
            addCriterion("CustomerID not like", value, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridIn(List<String> values) {
            addCriterion("CustomerID in", values, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridNotIn(List<String> values) {
            addCriterion("CustomerID not in", values, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridBetween(String value1, String value2) {
            addCriterion("CustomerID between", value1, value2, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridNotBetween(String value1, String value2) {
            addCriterion("CustomerID not between", value1, value2, "customerid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidIsNull() {
            addCriterion("EmployeeID is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeidIsNotNull() {
            addCriterion("EmployeeID is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeidEqualTo(Integer value) {
            addCriterion("EmployeeID =", value, "employeeid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidNotEqualTo(Integer value) {
            addCriterion("EmployeeID <>", value, "employeeid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidGreaterThan(Integer value) {
            addCriterion("EmployeeID >", value, "employeeid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("EmployeeID >=", value, "employeeid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidLessThan(Integer value) {
            addCriterion("EmployeeID <", value, "employeeid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidLessThanOrEqualTo(Integer value) {
            addCriterion("EmployeeID <=", value, "employeeid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidIn(List<Integer> values) {
            addCriterion("EmployeeID in", values, "employeeid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidNotIn(List<Integer> values) {
            addCriterion("EmployeeID not in", values, "employeeid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidBetween(Integer value1, Integer value2) {
            addCriterion("EmployeeID between", value1, value2, "employeeid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidNotBetween(Integer value1, Integer value2) {
            addCriterion("EmployeeID not between", value1, value2, "employeeid");
            return (Criteria) this;
        }

        public Criteria andOrderdateIsNull() {
            addCriterion("OrderDate is null");
            return (Criteria) this;
        }

        public Criteria andOrderdateIsNotNull() {
            addCriterion("OrderDate is not null");
            return (Criteria) this;
        }

        public Criteria andOrderdateEqualTo(Date value) {
            addCriterion("OrderDate =", value, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateNotEqualTo(Date value) {
            addCriterion("OrderDate <>", value, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateGreaterThan(Date value) {
            addCriterion("OrderDate >", value, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateGreaterThanOrEqualTo(Date value) {
            addCriterion("OrderDate >=", value, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateLessThan(Date value) {
            addCriterion("OrderDate <", value, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateLessThanOrEqualTo(Date value) {
            addCriterion("OrderDate <=", value, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateIn(List<Date> values) {
            addCriterion("OrderDate in", values, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateNotIn(List<Date> values) {
            addCriterion("OrderDate not in", values, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateBetween(Date value1, Date value2) {
            addCriterion("OrderDate between", value1, value2, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateNotBetween(Date value1, Date value2) {
            addCriterion("OrderDate not between", value1, value2, "orderdate");
            return (Criteria) this;
        }

        public Criteria andRequireddateIsNull() {
            addCriterion("RequiredDate is null");
            return (Criteria) this;
        }

        public Criteria andRequireddateIsNotNull() {
            addCriterion("RequiredDate is not null");
            return (Criteria) this;
        }

        public Criteria andRequireddateEqualTo(Date value) {
            addCriterion("RequiredDate =", value, "requireddate");
            return (Criteria) this;
        }

        public Criteria andRequireddateNotEqualTo(Date value) {
            addCriterion("RequiredDate <>", value, "requireddate");
            return (Criteria) this;
        }

        public Criteria andRequireddateGreaterThan(Date value) {
            addCriterion("RequiredDate >", value, "requireddate");
            return (Criteria) this;
        }

        public Criteria andRequireddateGreaterThanOrEqualTo(Date value) {
            addCriterion("RequiredDate >=", value, "requireddate");
            return (Criteria) this;
        }

        public Criteria andRequireddateLessThan(Date value) {
            addCriterion("RequiredDate <", value, "requireddate");
            return (Criteria) this;
        }

        public Criteria andRequireddateLessThanOrEqualTo(Date value) {
            addCriterion("RequiredDate <=", value, "requireddate");
            return (Criteria) this;
        }

        public Criteria andRequireddateIn(List<Date> values) {
            addCriterion("RequiredDate in", values, "requireddate");
            return (Criteria) this;
        }

        public Criteria andRequireddateNotIn(List<Date> values) {
            addCriterion("RequiredDate not in", values, "requireddate");
            return (Criteria) this;
        }

        public Criteria andRequireddateBetween(Date value1, Date value2) {
            addCriterion("RequiredDate between", value1, value2, "requireddate");
            return (Criteria) this;
        }

        public Criteria andRequireddateNotBetween(Date value1, Date value2) {
            addCriterion("RequiredDate not between", value1, value2, "requireddate");
            return (Criteria) this;
        }

        public Criteria andShippeddateIsNull() {
            addCriterion("ShippedDate is null");
            return (Criteria) this;
        }

        public Criteria andShippeddateIsNotNull() {
            addCriterion("ShippedDate is not null");
            return (Criteria) this;
        }

        public Criteria andShippeddateEqualTo(Date value) {
            addCriterion("ShippedDate =", value, "shippeddate");
            return (Criteria) this;
        }

        public Criteria andShippeddateNotEqualTo(Date value) {
            addCriterion("ShippedDate <>", value, "shippeddate");
            return (Criteria) this;
        }

        public Criteria andShippeddateGreaterThan(Date value) {
            addCriterion("ShippedDate >", value, "shippeddate");
            return (Criteria) this;
        }

        public Criteria andShippeddateGreaterThanOrEqualTo(Date value) {
            addCriterion("ShippedDate >=", value, "shippeddate");
            return (Criteria) this;
        }

        public Criteria andShippeddateLessThan(Date value) {
            addCriterion("ShippedDate <", value, "shippeddate");
            return (Criteria) this;
        }

        public Criteria andShippeddateLessThanOrEqualTo(Date value) {
            addCriterion("ShippedDate <=", value, "shippeddate");
            return (Criteria) this;
        }

        public Criteria andShippeddateIn(List<Date> values) {
            addCriterion("ShippedDate in", values, "shippeddate");
            return (Criteria) this;
        }

        public Criteria andShippeddateNotIn(List<Date> values) {
            addCriterion("ShippedDate not in", values, "shippeddate");
            return (Criteria) this;
        }

        public Criteria andShippeddateBetween(Date value1, Date value2) {
            addCriterion("ShippedDate between", value1, value2, "shippeddate");
            return (Criteria) this;
        }

        public Criteria andShippeddateNotBetween(Date value1, Date value2) {
            addCriterion("ShippedDate not between", value1, value2, "shippeddate");
            return (Criteria) this;
        }

        public Criteria andShipviaIsNull() {
            addCriterion("ShipVia is null");
            return (Criteria) this;
        }

        public Criteria andShipviaIsNotNull() {
            addCriterion("ShipVia is not null");
            return (Criteria) this;
        }

        public Criteria andShipviaEqualTo(Integer value) {
            addCriterion("ShipVia =", value, "shipvia");
            return (Criteria) this;
        }

        public Criteria andShipviaNotEqualTo(Integer value) {
            addCriterion("ShipVia <>", value, "shipvia");
            return (Criteria) this;
        }

        public Criteria andShipviaGreaterThan(Integer value) {
            addCriterion("ShipVia >", value, "shipvia");
            return (Criteria) this;
        }

        public Criteria andShipviaGreaterThanOrEqualTo(Integer value) {
            addCriterion("ShipVia >=", value, "shipvia");
            return (Criteria) this;
        }

        public Criteria andShipviaLessThan(Integer value) {
            addCriterion("ShipVia <", value, "shipvia");
            return (Criteria) this;
        }

        public Criteria andShipviaLessThanOrEqualTo(Integer value) {
            addCriterion("ShipVia <=", value, "shipvia");
            return (Criteria) this;
        }

        public Criteria andShipviaIn(List<Integer> values) {
            addCriterion("ShipVia in", values, "shipvia");
            return (Criteria) this;
        }

        public Criteria andShipviaNotIn(List<Integer> values) {
            addCriterion("ShipVia not in", values, "shipvia");
            return (Criteria) this;
        }

        public Criteria andShipviaBetween(Integer value1, Integer value2) {
            addCriterion("ShipVia between", value1, value2, "shipvia");
            return (Criteria) this;
        }

        public Criteria andShipviaNotBetween(Integer value1, Integer value2) {
            addCriterion("ShipVia not between", value1, value2, "shipvia");
            return (Criteria) this;
        }

        public Criteria andFreightIsNull() {
            addCriterion("Freight is null");
            return (Criteria) this;
        }

        public Criteria andFreightIsNotNull() {
            addCriterion("Freight is not null");
            return (Criteria) this;
        }

        public Criteria andFreightEqualTo(BigDecimal value) {
            addCriterion("Freight =", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightNotEqualTo(BigDecimal value) {
            addCriterion("Freight <>", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightGreaterThan(BigDecimal value) {
            addCriterion("Freight >", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Freight >=", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightLessThan(BigDecimal value) {
            addCriterion("Freight <", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("Freight <=", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightIn(List<BigDecimal> values) {
            addCriterion("Freight in", values, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightNotIn(List<BigDecimal> values) {
            addCriterion("Freight not in", values, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Freight between", value1, value2, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Freight not between", value1, value2, "freight");
            return (Criteria) this;
        }

        public Criteria andShipnameIsNull() {
            addCriterion("ShipName is null");
            return (Criteria) this;
        }

        public Criteria andShipnameIsNotNull() {
            addCriterion("ShipName is not null");
            return (Criteria) this;
        }

        public Criteria andShipnameEqualTo(String value) {
            addCriterion("ShipName =", value, "shipname");
            return (Criteria) this;
        }

        public Criteria andShipnameNotEqualTo(String value) {
            addCriterion("ShipName <>", value, "shipname");
            return (Criteria) this;
        }

        public Criteria andShipnameGreaterThan(String value) {
            addCriterion("ShipName >", value, "shipname");
            return (Criteria) this;
        }

        public Criteria andShipnameGreaterThanOrEqualTo(String value) {
            addCriterion("ShipName >=", value, "shipname");
            return (Criteria) this;
        }

        public Criteria andShipnameLessThan(String value) {
            addCriterion("ShipName <", value, "shipname");
            return (Criteria) this;
        }

        public Criteria andShipnameLessThanOrEqualTo(String value) {
            addCriterion("ShipName <=", value, "shipname");
            return (Criteria) this;
        }

        public Criteria andShipnameLike(String value) {
            addCriterion("ShipName like", value, "shipname");
            return (Criteria) this;
        }

        public Criteria andShipnameNotLike(String value) {
            addCriterion("ShipName not like", value, "shipname");
            return (Criteria) this;
        }

        public Criteria andShipnameIn(List<String> values) {
            addCriterion("ShipName in", values, "shipname");
            return (Criteria) this;
        }

        public Criteria andShipnameNotIn(List<String> values) {
            addCriterion("ShipName not in", values, "shipname");
            return (Criteria) this;
        }

        public Criteria andShipnameBetween(String value1, String value2) {
            addCriterion("ShipName between", value1, value2, "shipname");
            return (Criteria) this;
        }

        public Criteria andShipnameNotBetween(String value1, String value2) {
            addCriterion("ShipName not between", value1, value2, "shipname");
            return (Criteria) this;
        }

        public Criteria andShipaddressIsNull() {
            addCriterion("ShipAddress is null");
            return (Criteria) this;
        }

        public Criteria andShipaddressIsNotNull() {
            addCriterion("ShipAddress is not null");
            return (Criteria) this;
        }

        public Criteria andShipaddressEqualTo(String value) {
            addCriterion("ShipAddress =", value, "shipaddress");
            return (Criteria) this;
        }

        public Criteria andShipaddressNotEqualTo(String value) {
            addCriterion("ShipAddress <>", value, "shipaddress");
            return (Criteria) this;
        }

        public Criteria andShipaddressGreaterThan(String value) {
            addCriterion("ShipAddress >", value, "shipaddress");
            return (Criteria) this;
        }

        public Criteria andShipaddressGreaterThanOrEqualTo(String value) {
            addCriterion("ShipAddress >=", value, "shipaddress");
            return (Criteria) this;
        }

        public Criteria andShipaddressLessThan(String value) {
            addCriterion("ShipAddress <", value, "shipaddress");
            return (Criteria) this;
        }

        public Criteria andShipaddressLessThanOrEqualTo(String value) {
            addCriterion("ShipAddress <=", value, "shipaddress");
            return (Criteria) this;
        }

        public Criteria andShipaddressLike(String value) {
            addCriterion("ShipAddress like", value, "shipaddress");
            return (Criteria) this;
        }

        public Criteria andShipaddressNotLike(String value) {
            addCriterion("ShipAddress not like", value, "shipaddress");
            return (Criteria) this;
        }

        public Criteria andShipaddressIn(List<String> values) {
            addCriterion("ShipAddress in", values, "shipaddress");
            return (Criteria) this;
        }

        public Criteria andShipaddressNotIn(List<String> values) {
            addCriterion("ShipAddress not in", values, "shipaddress");
            return (Criteria) this;
        }

        public Criteria andShipaddressBetween(String value1, String value2) {
            addCriterion("ShipAddress between", value1, value2, "shipaddress");
            return (Criteria) this;
        }

        public Criteria andShipaddressNotBetween(String value1, String value2) {
            addCriterion("ShipAddress not between", value1, value2, "shipaddress");
            return (Criteria) this;
        }

        public Criteria andShipcityIsNull() {
            addCriterion("ShipCity is null");
            return (Criteria) this;
        }

        public Criteria andShipcityIsNotNull() {
            addCriterion("ShipCity is not null");
            return (Criteria) this;
        }

        public Criteria andShipcityEqualTo(String value) {
            addCriterion("ShipCity =", value, "shipcity");
            return (Criteria) this;
        }

        public Criteria andShipcityNotEqualTo(String value) {
            addCriterion("ShipCity <>", value, "shipcity");
            return (Criteria) this;
        }

        public Criteria andShipcityGreaterThan(String value) {
            addCriterion("ShipCity >", value, "shipcity");
            return (Criteria) this;
        }

        public Criteria andShipcityGreaterThanOrEqualTo(String value) {
            addCriterion("ShipCity >=", value, "shipcity");
            return (Criteria) this;
        }

        public Criteria andShipcityLessThan(String value) {
            addCriterion("ShipCity <", value, "shipcity");
            return (Criteria) this;
        }

        public Criteria andShipcityLessThanOrEqualTo(String value) {
            addCriterion("ShipCity <=", value, "shipcity");
            return (Criteria) this;
        }

        public Criteria andShipcityLike(String value) {
            addCriterion("ShipCity like", value, "shipcity");
            return (Criteria) this;
        }

        public Criteria andShipcityNotLike(String value) {
            addCriterion("ShipCity not like", value, "shipcity");
            return (Criteria) this;
        }

        public Criteria andShipcityIn(List<String> values) {
            addCriterion("ShipCity in", values, "shipcity");
            return (Criteria) this;
        }

        public Criteria andShipcityNotIn(List<String> values) {
            addCriterion("ShipCity not in", values, "shipcity");
            return (Criteria) this;
        }

        public Criteria andShipcityBetween(String value1, String value2) {
            addCriterion("ShipCity between", value1, value2, "shipcity");
            return (Criteria) this;
        }

        public Criteria andShipcityNotBetween(String value1, String value2) {
            addCriterion("ShipCity not between", value1, value2, "shipcity");
            return (Criteria) this;
        }

        public Criteria andShipregionIsNull() {
            addCriterion("ShipRegion is null");
            return (Criteria) this;
        }

        public Criteria andShipregionIsNotNull() {
            addCriterion("ShipRegion is not null");
            return (Criteria) this;
        }

        public Criteria andShipregionEqualTo(String value) {
            addCriterion("ShipRegion =", value, "shipregion");
            return (Criteria) this;
        }

        public Criteria andShipregionNotEqualTo(String value) {
            addCriterion("ShipRegion <>", value, "shipregion");
            return (Criteria) this;
        }

        public Criteria andShipregionGreaterThan(String value) {
            addCriterion("ShipRegion >", value, "shipregion");
            return (Criteria) this;
        }

        public Criteria andShipregionGreaterThanOrEqualTo(String value) {
            addCriterion("ShipRegion >=", value, "shipregion");
            return (Criteria) this;
        }

        public Criteria andShipregionLessThan(String value) {
            addCriterion("ShipRegion <", value, "shipregion");
            return (Criteria) this;
        }

        public Criteria andShipregionLessThanOrEqualTo(String value) {
            addCriterion("ShipRegion <=", value, "shipregion");
            return (Criteria) this;
        }

        public Criteria andShipregionLike(String value) {
            addCriterion("ShipRegion like", value, "shipregion");
            return (Criteria) this;
        }

        public Criteria andShipregionNotLike(String value) {
            addCriterion("ShipRegion not like", value, "shipregion");
            return (Criteria) this;
        }

        public Criteria andShipregionIn(List<String> values) {
            addCriterion("ShipRegion in", values, "shipregion");
            return (Criteria) this;
        }

        public Criteria andShipregionNotIn(List<String> values) {
            addCriterion("ShipRegion not in", values, "shipregion");
            return (Criteria) this;
        }

        public Criteria andShipregionBetween(String value1, String value2) {
            addCriterion("ShipRegion between", value1, value2, "shipregion");
            return (Criteria) this;
        }

        public Criteria andShipregionNotBetween(String value1, String value2) {
            addCriterion("ShipRegion not between", value1, value2, "shipregion");
            return (Criteria) this;
        }

        public Criteria andShippostalcodeIsNull() {
            addCriterion("ShipPostalCode is null");
            return (Criteria) this;
        }

        public Criteria andShippostalcodeIsNotNull() {
            addCriterion("ShipPostalCode is not null");
            return (Criteria) this;
        }

        public Criteria andShippostalcodeEqualTo(String value) {
            addCriterion("ShipPostalCode =", value, "shippostalcode");
            return (Criteria) this;
        }

        public Criteria andShippostalcodeNotEqualTo(String value) {
            addCriterion("ShipPostalCode <>", value, "shippostalcode");
            return (Criteria) this;
        }

        public Criteria andShippostalcodeGreaterThan(String value) {
            addCriterion("ShipPostalCode >", value, "shippostalcode");
            return (Criteria) this;
        }

        public Criteria andShippostalcodeGreaterThanOrEqualTo(String value) {
            addCriterion("ShipPostalCode >=", value, "shippostalcode");
            return (Criteria) this;
        }

        public Criteria andShippostalcodeLessThan(String value) {
            addCriterion("ShipPostalCode <", value, "shippostalcode");
            return (Criteria) this;
        }

        public Criteria andShippostalcodeLessThanOrEqualTo(String value) {
            addCriterion("ShipPostalCode <=", value, "shippostalcode");
            return (Criteria) this;
        }

        public Criteria andShippostalcodeLike(String value) {
            addCriterion("ShipPostalCode like", value, "shippostalcode");
            return (Criteria) this;
        }

        public Criteria andShippostalcodeNotLike(String value) {
            addCriterion("ShipPostalCode not like", value, "shippostalcode");
            return (Criteria) this;
        }

        public Criteria andShippostalcodeIn(List<String> values) {
            addCriterion("ShipPostalCode in", values, "shippostalcode");
            return (Criteria) this;
        }

        public Criteria andShippostalcodeNotIn(List<String> values) {
            addCriterion("ShipPostalCode not in", values, "shippostalcode");
            return (Criteria) this;
        }

        public Criteria andShippostalcodeBetween(String value1, String value2) {
            addCriterion("ShipPostalCode between", value1, value2, "shippostalcode");
            return (Criteria) this;
        }

        public Criteria andShippostalcodeNotBetween(String value1, String value2) {
            addCriterion("ShipPostalCode not between", value1, value2, "shippostalcode");
            return (Criteria) this;
        }

        public Criteria andShipcountryIsNull() {
            addCriterion("ShipCountry is null");
            return (Criteria) this;
        }

        public Criteria andShipcountryIsNotNull() {
            addCriterion("ShipCountry is not null");
            return (Criteria) this;
        }

        public Criteria andShipcountryEqualTo(String value) {
            addCriterion("ShipCountry =", value, "shipcountry");
            return (Criteria) this;
        }

        public Criteria andShipcountryNotEqualTo(String value) {
            addCriterion("ShipCountry <>", value, "shipcountry");
            return (Criteria) this;
        }

        public Criteria andShipcountryGreaterThan(String value) {
            addCriterion("ShipCountry >", value, "shipcountry");
            return (Criteria) this;
        }

        public Criteria andShipcountryGreaterThanOrEqualTo(String value) {
            addCriterion("ShipCountry >=", value, "shipcountry");
            return (Criteria) this;
        }

        public Criteria andShipcountryLessThan(String value) {
            addCriterion("ShipCountry <", value, "shipcountry");
            return (Criteria) this;
        }

        public Criteria andShipcountryLessThanOrEqualTo(String value) {
            addCriterion("ShipCountry <=", value, "shipcountry");
            return (Criteria) this;
        }

        public Criteria andShipcountryLike(String value) {
            addCriterion("ShipCountry like", value, "shipcountry");
            return (Criteria) this;
        }

        public Criteria andShipcountryNotLike(String value) {
            addCriterion("ShipCountry not like", value, "shipcountry");
            return (Criteria) this;
        }

        public Criteria andShipcountryIn(List<String> values) {
            addCriterion("ShipCountry in", values, "shipcountry");
            return (Criteria) this;
        }

        public Criteria andShipcountryNotIn(List<String> values) {
            addCriterion("ShipCountry not in", values, "shipcountry");
            return (Criteria) this;
        }

        public Criteria andShipcountryBetween(String value1, String value2) {
            addCriterion("ShipCountry between", value1, value2, "shipcountry");
            return (Criteria) this;
        }

        public Criteria andShipcountryNotBetween(String value1, String value2) {
            addCriterion("ShipCountry not between", value1, value2, "shipcountry");
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