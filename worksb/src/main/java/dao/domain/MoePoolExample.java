package dao.domain;

import java.util.ArrayList;
import java.util.List;

public class MoePoolExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table moepool
     *
     * @mbg.generated Fri Jan 03 17:17:47 CST 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table moepool
     *
     * @mbg.generated Fri Jan 03 17:17:47 CST 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table moepool
     *
     * @mbg.generated Fri Jan 03 17:17:47 CST 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table moepool
     *
     * @mbg.generated Fri Jan 03 17:17:47 CST 2020
     */
    public MoePoolExample() {
        oredCriteria = new ArrayList<>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table moepool
     *
     * @mbg.generated Fri Jan 03 17:17:47 CST 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table moepool
     *
     * @mbg.generated Fri Jan 03 17:17:47 CST 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table moepool
     *
     * @mbg.generated Fri Jan 03 17:17:47 CST 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table moepool
     *
     * @mbg.generated Fri Jan 03 17:17:47 CST 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table moepool
     *
     * @mbg.generated Fri Jan 03 17:17:47 CST 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table moepool
     *
     * @mbg.generated Fri Jan 03 17:17:47 CST 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table moepool
     *
     * @mbg.generated Fri Jan 03 17:17:47 CST 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table moepool
     *
     * @mbg.generated Fri Jan 03 17:17:47 CST 2020
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table moepool
     *
     * @mbg.generated Fri Jan 03 17:17:47 CST 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table moepool
     *
     * @mbg.generated Fri Jan 03 17:17:47 CST 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table moepool
     *
     * @mbg.generated Fri Jan 03 17:17:47 CST 2020
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
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

        public Criteria andPostidIsNull() {
            addCriterion("postid is null");
            return (Criteria) this;
        }

        public Criteria andPostidIsNotNull() {
            addCriterion("postid is not null");
            return (Criteria) this;
        }

        public Criteria andPostidEqualTo(Integer value) {
            addCriterion("postid =", value, "postid");
            return (Criteria) this;
        }

        public Criteria andPostidNotEqualTo(Integer value) {
            addCriterion("postid <>", value, "postid");
            return (Criteria) this;
        }

        public Criteria andPostidGreaterThan(Integer value) {
            addCriterion("postid >", value, "postid");
            return (Criteria) this;
        }

        public Criteria andPostidGreaterThanOrEqualTo(Integer value) {
            addCriterion("postid >=", value, "postid");
            return (Criteria) this;
        }

        public Criteria andPostidLessThan(Integer value) {
            addCriterion("postid <", value, "postid");
            return (Criteria) this;
        }

        public Criteria andPostidLessThanOrEqualTo(Integer value) {
            addCriterion("postid <=", value, "postid");
            return (Criteria) this;
        }

        public Criteria andPostidIn(List<Integer> values) {
            addCriterion("postid in", values, "postid");
            return (Criteria) this;
        }

        public Criteria andPostidNotIn(List<Integer> values) {
            addCriterion("postid not in", values, "postid");
            return (Criteria) this;
        }

        public Criteria andPostidBetween(Integer value1, Integer value2) {
            addCriterion("postid between", value1, value2, "postid");
            return (Criteria) this;
        }

        public Criteria andPostidNotBetween(Integer value1, Integer value2) {
            addCriterion("postid not between", value1, value2, "postid");
            return (Criteria) this;
        }

        public Criteria andTitle1IsNull() {
            addCriterion("title1 is null");
            return (Criteria) this;
        }

        public Criteria andTitle1IsNotNull() {
            addCriterion("title1 is not null");
            return (Criteria) this;
        }

        public Criteria andTitle1EqualTo(String value) {
            addCriterion("title1 =", value, "title1");
            return (Criteria) this;
        }

        public Criteria andTitle1NotEqualTo(String value) {
            addCriterion("title1 <>", value, "title1");
            return (Criteria) this;
        }

        public Criteria andTitle1GreaterThan(String value) {
            addCriterion("title1 >", value, "title1");
            return (Criteria) this;
        }

        public Criteria andTitle1GreaterThanOrEqualTo(String value) {
            addCriterion("title1 >=", value, "title1");
            return (Criteria) this;
        }

        public Criteria andTitle1LessThan(String value) {
            addCriterion("title1 <", value, "title1");
            return (Criteria) this;
        }

        public Criteria andTitle1LessThanOrEqualTo(String value) {
            addCriterion("title1 <=", value, "title1");
            return (Criteria) this;
        }

        public Criteria andTitle1Like(String value) {
            addCriterion("title1 like", value, "title1");
            return (Criteria) this;
        }

        public Criteria andTitle1NotLike(String value) {
            addCriterion("title1 not like", value, "title1");
            return (Criteria) this;
        }

        public Criteria andTitle1In(List<String> values) {
            addCriterion("title1 in", values, "title1");
            return (Criteria) this;
        }

        public Criteria andTitle1NotIn(List<String> values) {
            addCriterion("title1 not in", values, "title1");
            return (Criteria) this;
        }

        public Criteria andTitle1Between(String value1, String value2) {
            addCriterion("title1 between", value1, value2, "title1");
            return (Criteria) this;
        }

        public Criteria andTitle1NotBetween(String value1, String value2) {
            addCriterion("title1 not between", value1, value2, "title1");
            return (Criteria) this;
        }

        public Criteria andTitle2IsNull() {
            addCriterion("title2 is null");
            return (Criteria) this;
        }

        public Criteria andTitle2IsNotNull() {
            addCriterion("title2 is not null");
            return (Criteria) this;
        }

        public Criteria andTitle2EqualTo(String value) {
            addCriterion("title2 =", value, "title2");
            return (Criteria) this;
        }

        public Criteria andTitle2NotEqualTo(String value) {
            addCriterion("title2 <>", value, "title2");
            return (Criteria) this;
        }

        public Criteria andTitle2GreaterThan(String value) {
            addCriterion("title2 >", value, "title2");
            return (Criteria) this;
        }

        public Criteria andTitle2GreaterThanOrEqualTo(String value) {
            addCriterion("title2 >=", value, "title2");
            return (Criteria) this;
        }

        public Criteria andTitle2LessThan(String value) {
            addCriterion("title2 <", value, "title2");
            return (Criteria) this;
        }

        public Criteria andTitle2LessThanOrEqualTo(String value) {
            addCriterion("title2 <=", value, "title2");
            return (Criteria) this;
        }

        public Criteria andTitle2Like(String value) {
            addCriterion("title2 like", value, "title2");
            return (Criteria) this;
        }

        public Criteria andTitle2NotLike(String value) {
            addCriterion("title2 not like", value, "title2");
            return (Criteria) this;
        }

        public Criteria andTitle2In(List<String> values) {
            addCriterion("title2 in", values, "title2");
            return (Criteria) this;
        }

        public Criteria andTitle2NotIn(List<String> values) {
            addCriterion("title2 not in", values, "title2");
            return (Criteria) this;
        }

        public Criteria andTitle2Between(String value1, String value2) {
            addCriterion("title2 between", value1, value2, "title2");
            return (Criteria) this;
        }

        public Criteria andTitle2NotBetween(String value1, String value2) {
            addCriterion("title2 not between", value1, value2, "title2");
            return (Criteria) this;
        }

        public Criteria andTitle3IsNull() {
            addCriterion("title3 is null");
            return (Criteria) this;
        }

        public Criteria andTitle3IsNotNull() {
            addCriterion("title3 is not null");
            return (Criteria) this;
        }

        public Criteria andTitle3EqualTo(String value) {
            addCriterion("title3 =", value, "title3");
            return (Criteria) this;
        }

        public Criteria andTitle3NotEqualTo(String value) {
            addCriterion("title3 <>", value, "title3");
            return (Criteria) this;
        }

        public Criteria andTitle3GreaterThan(String value) {
            addCriterion("title3 >", value, "title3");
            return (Criteria) this;
        }

        public Criteria andTitle3GreaterThanOrEqualTo(String value) {
            addCriterion("title3 >=", value, "title3");
            return (Criteria) this;
        }

        public Criteria andTitle3LessThan(String value) {
            addCriterion("title3 <", value, "title3");
            return (Criteria) this;
        }

        public Criteria andTitle3LessThanOrEqualTo(String value) {
            addCriterion("title3 <=", value, "title3");
            return (Criteria) this;
        }

        public Criteria andTitle3Like(String value) {
            addCriterion("title3 like", value, "title3");
            return (Criteria) this;
        }

        public Criteria andTitle3NotLike(String value) {
            addCriterion("title3 not like", value, "title3");
            return (Criteria) this;
        }

        public Criteria andTitle3In(List<String> values) {
            addCriterion("title3 in", values, "title3");
            return (Criteria) this;
        }

        public Criteria andTitle3NotIn(List<String> values) {
            addCriterion("title3 not in", values, "title3");
            return (Criteria) this;
        }

        public Criteria andTitle3Between(String value1, String value2) {
            addCriterion("title3 between", value1, value2, "title3");
            return (Criteria) this;
        }

        public Criteria andTitle3NotBetween(String value1, String value2) {
            addCriterion("title3 not between", value1, value2, "title3");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andAbsurlIsNull() {
            addCriterion("absurl is null");
            return (Criteria) this;
        }

        public Criteria andAbsurlIsNotNull() {
            addCriterion("absurl is not null");
            return (Criteria) this;
        }

        public Criteria andAbsurlEqualTo(String value) {
            addCriterion("absurl =", value, "absurl");
            return (Criteria) this;
        }

        public Criteria andAbsurlNotEqualTo(String value) {
            addCriterion("absurl <>", value, "absurl");
            return (Criteria) this;
        }

        public Criteria andAbsurlGreaterThan(String value) {
            addCriterion("absurl >", value, "absurl");
            return (Criteria) this;
        }

        public Criteria andAbsurlGreaterThanOrEqualTo(String value) {
            addCriterion("absurl >=", value, "absurl");
            return (Criteria) this;
        }

        public Criteria andAbsurlLessThan(String value) {
            addCriterion("absurl <", value, "absurl");
            return (Criteria) this;
        }

        public Criteria andAbsurlLessThanOrEqualTo(String value) {
            addCriterion("absurl <=", value, "absurl");
            return (Criteria) this;
        }

        public Criteria andAbsurlLike(String value) {
            addCriterion("absurl like", value, "absurl");
            return (Criteria) this;
        }

        public Criteria andAbsurlNotLike(String value) {
            addCriterion("absurl not like", value, "absurl");
            return (Criteria) this;
        }

        public Criteria andAbsurlIn(List<String> values) {
            addCriterion("absurl in", values, "absurl");
            return (Criteria) this;
        }

        public Criteria andAbsurlNotIn(List<String> values) {
            addCriterion("absurl not in", values, "absurl");
            return (Criteria) this;
        }

        public Criteria andAbsurlBetween(String value1, String value2) {
            addCriterion("absurl between", value1, value2, "absurl");
            return (Criteria) this;
        }

        public Criteria andAbsurlNotBetween(String value1, String value2) {
            addCriterion("absurl not between", value1, value2, "absurl");
            return (Criteria) this;
        }

        public Criteria andFilePathIsNull() {
            addCriterion("file_path is null");
            return (Criteria) this;
        }

        public Criteria andFilePathIsNotNull() {
            addCriterion("file_path is not null");
            return (Criteria) this;
        }

        public Criteria andFilePathEqualTo(String value) {
            addCriterion("file_path =", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotEqualTo(String value) {
            addCriterion("file_path <>", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathGreaterThan(String value) {
            addCriterion("file_path >", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("file_path >=", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLessThan(String value) {
            addCriterion("file_path <", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLessThanOrEqualTo(String value) {
            addCriterion("file_path <=", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLike(String value) {
            addCriterion("file_path like", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotLike(String value) {
            addCriterion("file_path not like", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathIn(List<String> values) {
            addCriterion("file_path in", values, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotIn(List<String> values) {
            addCriterion("file_path not in", values, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathBetween(String value1, String value2) {
            addCriterion("file_path between", value1, value2, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotBetween(String value1, String value2) {
            addCriterion("file_path not between", value1, value2, "filePath");
            return (Criteria) this;
        }

        public Criteria andDownloadIsNull() {
            addCriterion("download is null");
            return (Criteria) this;
        }

        public Criteria andDownloadIsNotNull() {
            addCriterion("download is not null");
            return (Criteria) this;
        }

        public Criteria andDownloadEqualTo(String value) {
            addCriterion("download =", value, "download");
            return (Criteria) this;
        }

        public Criteria andDownloadNotEqualTo(String value) {
            addCriterion("download <>", value, "download");
            return (Criteria) this;
        }

        public Criteria andDownloadGreaterThan(String value) {
            addCriterion("download >", value, "download");
            return (Criteria) this;
        }

        public Criteria andDownloadGreaterThanOrEqualTo(String value) {
            addCriterion("download >=", value, "download");
            return (Criteria) this;
        }

        public Criteria andDownloadLessThan(String value) {
            addCriterion("download <", value, "download");
            return (Criteria) this;
        }

        public Criteria andDownloadLessThanOrEqualTo(String value) {
            addCriterion("download <=", value, "download");
            return (Criteria) this;
        }

        public Criteria andDownloadLike(String value) {
            addCriterion("download like", value, "download");
            return (Criteria) this;
        }

        public Criteria andDownloadNotLike(String value) {
            addCriterion("download not like", value, "download");
            return (Criteria) this;
        }

        public Criteria andDownloadIn(List<String> values) {
            addCriterion("download in", values, "download");
            return (Criteria) this;
        }

        public Criteria andDownloadNotIn(List<String> values) {
            addCriterion("download not in", values, "download");
            return (Criteria) this;
        }

        public Criteria andDownloadBetween(String value1, String value2) {
            addCriterion("download between", value1, value2, "download");
            return (Criteria) this;
        }

        public Criteria andDownloadNotBetween(String value1, String value2) {
            addCriterion("download not between", value1, value2, "download");
            return (Criteria) this;
        }

        public Criteria andAbsdownloadIsNull() {
            addCriterion("absdownload is null");
            return (Criteria) this;
        }

        public Criteria andAbsdownloadIsNotNull() {
            addCriterion("absdownload is not null");
            return (Criteria) this;
        }

        public Criteria andAbsdownloadEqualTo(String value) {
            addCriterion("absdownload =", value, "absdownload");
            return (Criteria) this;
        }

        public Criteria andAbsdownloadNotEqualTo(String value) {
            addCriterion("absdownload <>", value, "absdownload");
            return (Criteria) this;
        }

        public Criteria andAbsdownloadGreaterThan(String value) {
            addCriterion("absdownload >", value, "absdownload");
            return (Criteria) this;
        }

        public Criteria andAbsdownloadGreaterThanOrEqualTo(String value) {
            addCriterion("absdownload >=", value, "absdownload");
            return (Criteria) this;
        }

        public Criteria andAbsdownloadLessThan(String value) {
            addCriterion("absdownload <", value, "absdownload");
            return (Criteria) this;
        }

        public Criteria andAbsdownloadLessThanOrEqualTo(String value) {
            addCriterion("absdownload <=", value, "absdownload");
            return (Criteria) this;
        }

        public Criteria andAbsdownloadLike(String value) {
            addCriterion("absdownload like", value, "absdownload");
            return (Criteria) this;
        }

        public Criteria andAbsdownloadNotLike(String value) {
            addCriterion("absdownload not like", value, "absdownload");
            return (Criteria) this;
        }

        public Criteria andAbsdownloadIn(List<String> values) {
            addCriterion("absdownload in", values, "absdownload");
            return (Criteria) this;
        }

        public Criteria andAbsdownloadNotIn(List<String> values) {
            addCriterion("absdownload not in", values, "absdownload");
            return (Criteria) this;
        }

        public Criteria andAbsdownloadBetween(String value1, String value2) {
            addCriterion("absdownload between", value1, value2, "absdownload");
            return (Criteria) this;
        }

        public Criteria andAbsdownloadNotBetween(String value1, String value2) {
            addCriterion("absdownload not between", value1, value2, "absdownload");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table moepool
     *
     * @mbg.generated do_not_delete_during_merge Fri Jan 03 17:17:47 CST 2020
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table moepool
     *
     * @mbg.generated Fri Jan 03 17:17:47 CST 2020
     */
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