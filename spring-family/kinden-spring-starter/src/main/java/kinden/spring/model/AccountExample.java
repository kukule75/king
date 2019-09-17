package kinden.spring.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AccountExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAccNoIsNull() {
            addCriterion("acc_no is null");
            return (Criteria) this;
        }

        public Criteria andAccNoIsNotNull() {
            addCriterion("acc_no is not null");
            return (Criteria) this;
        }

        public Criteria andAccNoEqualTo(String value) {
            addCriterion("acc_no =", value, "accNo");
            return (Criteria) this;
        }

        public Criteria andAccNoNotEqualTo(String value) {
            addCriterion("acc_no <>", value, "accNo");
            return (Criteria) this;
        }

        public Criteria andAccNoGreaterThan(String value) {
            addCriterion("acc_no >", value, "accNo");
            return (Criteria) this;
        }

        public Criteria andAccNoGreaterThanOrEqualTo(String value) {
            addCriterion("acc_no >=", value, "accNo");
            return (Criteria) this;
        }

        public Criteria andAccNoLessThan(String value) {
            addCriterion("acc_no <", value, "accNo");
            return (Criteria) this;
        }

        public Criteria andAccNoLessThanOrEqualTo(String value) {
            addCriterion("acc_no <=", value, "accNo");
            return (Criteria) this;
        }

        public Criteria andAccNoLike(String value) {
            addCriterion("acc_no like", value, "accNo");
            return (Criteria) this;
        }

        public Criteria andAccNoNotLike(String value) {
            addCriterion("acc_no not like", value, "accNo");
            return (Criteria) this;
        }

        public Criteria andAccNoIn(List<String> values) {
            addCriterion("acc_no in", values, "accNo");
            return (Criteria) this;
        }

        public Criteria andAccNoNotIn(List<String> values) {
            addCriterion("acc_no not in", values, "accNo");
            return (Criteria) this;
        }

        public Criteria andAccNoBetween(String value1, String value2) {
            addCriterion("acc_no between", value1, value2, "accNo");
            return (Criteria) this;
        }

        public Criteria andAccNoNotBetween(String value1, String value2) {
            addCriterion("acc_no not between", value1, value2, "accNo");
            return (Criteria) this;
        }

        public Criteria andAccCodeIsNull() {
            addCriterion("acc_code is null");
            return (Criteria) this;
        }

        public Criteria andAccCodeIsNotNull() {
            addCriterion("acc_code is not null");
            return (Criteria) this;
        }

        public Criteria andAccCodeEqualTo(Integer value) {
            addCriterion("acc_code =", value, "accCode");
            return (Criteria) this;
        }

        public Criteria andAccCodeNotEqualTo(Integer value) {
            addCriterion("acc_code <>", value, "accCode");
            return (Criteria) this;
        }

        public Criteria andAccCodeGreaterThan(Integer value) {
            addCriterion("acc_code >", value, "accCode");
            return (Criteria) this;
        }

        public Criteria andAccCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("acc_code >=", value, "accCode");
            return (Criteria) this;
        }

        public Criteria andAccCodeLessThan(Integer value) {
            addCriterion("acc_code <", value, "accCode");
            return (Criteria) this;
        }

        public Criteria andAccCodeLessThanOrEqualTo(Integer value) {
            addCriterion("acc_code <=", value, "accCode");
            return (Criteria) this;
        }

        public Criteria andAccCodeIn(List<Integer> values) {
            addCriterion("acc_code in", values, "accCode");
            return (Criteria) this;
        }

        public Criteria andAccCodeNotIn(List<Integer> values) {
            addCriterion("acc_code not in", values, "accCode");
            return (Criteria) this;
        }

        public Criteria andAccCodeBetween(Integer value1, Integer value2) {
            addCriterion("acc_code between", value1, value2, "accCode");
            return (Criteria) this;
        }

        public Criteria andAccCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("acc_code not between", value1, value2, "accCode");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNull() {
            addCriterion("balance is null");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNotNull() {
            addCriterion("balance is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceEqualTo(BigDecimal value) {
            addCriterion("balance =", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotEqualTo(BigDecimal value) {
            addCriterion("balance <>", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThan(BigDecimal value) {
            addCriterion("balance >", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("balance >=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThan(BigDecimal value) {
            addCriterion("balance <", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("balance <=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceIn(List<BigDecimal> values) {
            addCriterion("balance in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotIn(List<BigDecimal> values) {
            addCriterion("balance not in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance not between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andFreezeAmountIsNull() {
            addCriterion("freeze_amount is null");
            return (Criteria) this;
        }

        public Criteria andFreezeAmountIsNotNull() {
            addCriterion("freeze_amount is not null");
            return (Criteria) this;
        }

        public Criteria andFreezeAmountEqualTo(BigDecimal value) {
            addCriterion("freeze_amount =", value, "freezeAmount");
            return (Criteria) this;
        }

        public Criteria andFreezeAmountNotEqualTo(BigDecimal value) {
            addCriterion("freeze_amount <>", value, "freezeAmount");
            return (Criteria) this;
        }

        public Criteria andFreezeAmountGreaterThan(BigDecimal value) {
            addCriterion("freeze_amount >", value, "freezeAmount");
            return (Criteria) this;
        }

        public Criteria andFreezeAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("freeze_amount >=", value, "freezeAmount");
            return (Criteria) this;
        }

        public Criteria andFreezeAmountLessThan(BigDecimal value) {
            addCriterion("freeze_amount <", value, "freezeAmount");
            return (Criteria) this;
        }

        public Criteria andFreezeAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("freeze_amount <=", value, "freezeAmount");
            return (Criteria) this;
        }

        public Criteria andFreezeAmountIn(List<BigDecimal> values) {
            addCriterion("freeze_amount in", values, "freezeAmount");
            return (Criteria) this;
        }

        public Criteria andFreezeAmountNotIn(List<BigDecimal> values) {
            addCriterion("freeze_amount not in", values, "freezeAmount");
            return (Criteria) this;
        }

        public Criteria andFreezeAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("freeze_amount between", value1, value2, "freezeAmount");
            return (Criteria) this;
        }

        public Criteria andFreezeAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("freeze_amount not between", value1, value2, "freezeAmount");
            return (Criteria) this;
        }

        public Criteria andSignIsNull() {
            addCriterion("sign is null");
            return (Criteria) this;
        }

        public Criteria andSignIsNotNull() {
            addCriterion("sign is not null");
            return (Criteria) this;
        }

        public Criteria andSignEqualTo(String value) {
            addCriterion("sign =", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotEqualTo(String value) {
            addCriterion("sign <>", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignGreaterThan(String value) {
            addCriterion("sign >", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignGreaterThanOrEqualTo(String value) {
            addCriterion("sign >=", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLessThan(String value) {
            addCriterion("sign <", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLessThanOrEqualTo(String value) {
            addCriterion("sign <=", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLike(String value) {
            addCriterion("sign like", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotLike(String value) {
            addCriterion("sign not like", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignIn(List<String> values) {
            addCriterion("sign in", values, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotIn(List<String> values) {
            addCriterion("sign not in", values, "sign");
            return (Criteria) this;
        }

        public Criteria andSignBetween(String value1, String value2) {
            addCriterion("sign between", value1, value2, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotBetween(String value1, String value2) {
            addCriterion("sign not between", value1, value2, "sign");
            return (Criteria) this;
        }

        public Criteria andMaxBalanceIsNull() {
            addCriterion("max_balance is null");
            return (Criteria) this;
        }

        public Criteria andMaxBalanceIsNotNull() {
            addCriterion("max_balance is not null");
            return (Criteria) this;
        }

        public Criteria andMaxBalanceEqualTo(BigDecimal value) {
            addCriterion("max_balance =", value, "maxBalance");
            return (Criteria) this;
        }

        public Criteria andMaxBalanceNotEqualTo(BigDecimal value) {
            addCriterion("max_balance <>", value, "maxBalance");
            return (Criteria) this;
        }

        public Criteria andMaxBalanceGreaterThan(BigDecimal value) {
            addCriterion("max_balance >", value, "maxBalance");
            return (Criteria) this;
        }

        public Criteria andMaxBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("max_balance >=", value, "maxBalance");
            return (Criteria) this;
        }

        public Criteria andMaxBalanceLessThan(BigDecimal value) {
            addCriterion("max_balance <", value, "maxBalance");
            return (Criteria) this;
        }

        public Criteria andMaxBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("max_balance <=", value, "maxBalance");
            return (Criteria) this;
        }

        public Criteria andMaxBalanceIn(List<BigDecimal> values) {
            addCriterion("max_balance in", values, "maxBalance");
            return (Criteria) this;
        }

        public Criteria andMaxBalanceNotIn(List<BigDecimal> values) {
            addCriterion("max_balance not in", values, "maxBalance");
            return (Criteria) this;
        }

        public Criteria andMaxBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("max_balance between", value1, value2, "maxBalance");
            return (Criteria) this;
        }

        public Criteria andMaxBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("max_balance not between", value1, value2, "maxBalance");
            return (Criteria) this;
        }

        public Criteria andMinBalanceIsNull() {
            addCriterion("min_balance is null");
            return (Criteria) this;
        }

        public Criteria andMinBalanceIsNotNull() {
            addCriterion("min_balance is not null");
            return (Criteria) this;
        }

        public Criteria andMinBalanceEqualTo(BigDecimal value) {
            addCriterion("min_balance =", value, "minBalance");
            return (Criteria) this;
        }

        public Criteria andMinBalanceNotEqualTo(BigDecimal value) {
            addCriterion("min_balance <>", value, "minBalance");
            return (Criteria) this;
        }

        public Criteria andMinBalanceGreaterThan(BigDecimal value) {
            addCriterion("min_balance >", value, "minBalance");
            return (Criteria) this;
        }

        public Criteria andMinBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("min_balance >=", value, "minBalance");
            return (Criteria) this;
        }

        public Criteria andMinBalanceLessThan(BigDecimal value) {
            addCriterion("min_balance <", value, "minBalance");
            return (Criteria) this;
        }

        public Criteria andMinBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("min_balance <=", value, "minBalance");
            return (Criteria) this;
        }

        public Criteria andMinBalanceIn(List<BigDecimal> values) {
            addCriterion("min_balance in", values, "minBalance");
            return (Criteria) this;
        }

        public Criteria andMinBalanceNotIn(List<BigDecimal> values) {
            addCriterion("min_balance not in", values, "minBalance");
            return (Criteria) this;
        }

        public Criteria andMinBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("min_balance between", value1, value2, "minBalance");
            return (Criteria) this;
        }

        public Criteria andMinBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("min_balance not between", value1, value2, "minBalance");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusCodeIsNull() {
            addCriterion("status_code is null");
            return (Criteria) this;
        }

        public Criteria andStatusCodeIsNotNull() {
            addCriterion("status_code is not null");
            return (Criteria) this;
        }

        public Criteria andStatusCodeEqualTo(Long value) {
            addCriterion("status_code =", value, "statusCode");
            return (Criteria) this;
        }

        public Criteria andStatusCodeNotEqualTo(Long value) {
            addCriterion("status_code <>", value, "statusCode");
            return (Criteria) this;
        }

        public Criteria andStatusCodeGreaterThan(Long value) {
            addCriterion("status_code >", value, "statusCode");
            return (Criteria) this;
        }

        public Criteria andStatusCodeGreaterThanOrEqualTo(Long value) {
            addCriterion("status_code >=", value, "statusCode");
            return (Criteria) this;
        }

        public Criteria andStatusCodeLessThan(Long value) {
            addCriterion("status_code <", value, "statusCode");
            return (Criteria) this;
        }

        public Criteria andStatusCodeLessThanOrEqualTo(Long value) {
            addCriterion("status_code <=", value, "statusCode");
            return (Criteria) this;
        }

        public Criteria andStatusCodeIn(List<Long> values) {
            addCriterion("status_code in", values, "statusCode");
            return (Criteria) this;
        }

        public Criteria andStatusCodeNotIn(List<Long> values) {
            addCriterion("status_code not in", values, "statusCode");
            return (Criteria) this;
        }

        public Criteria andStatusCodeBetween(Long value1, Long value2) {
            addCriterion("status_code between", value1, value2, "statusCode");
            return (Criteria) this;
        }

        public Criteria andStatusCodeNotBetween(Long value1, Long value2) {
            addCriterion("status_code not between", value1, value2, "statusCode");
            return (Criteria) this;
        }

        public Criteria andAccTypeIsNull() {
            addCriterion("acc_type is null");
            return (Criteria) this;
        }

        public Criteria andAccTypeIsNotNull() {
            addCriterion("acc_type is not null");
            return (Criteria) this;
        }

        public Criteria andAccTypeEqualTo(String value) {
            addCriterion("acc_type =", value, "accType");
            return (Criteria) this;
        }

        public Criteria andAccTypeNotEqualTo(String value) {
            addCriterion("acc_type <>", value, "accType");
            return (Criteria) this;
        }

        public Criteria andAccTypeGreaterThan(String value) {
            addCriterion("acc_type >", value, "accType");
            return (Criteria) this;
        }

        public Criteria andAccTypeGreaterThanOrEqualTo(String value) {
            addCriterion("acc_type >=", value, "accType");
            return (Criteria) this;
        }

        public Criteria andAccTypeLessThan(String value) {
            addCriterion("acc_type <", value, "accType");
            return (Criteria) this;
        }

        public Criteria andAccTypeLessThanOrEqualTo(String value) {
            addCriterion("acc_type <=", value, "accType");
            return (Criteria) this;
        }

        public Criteria andAccTypeLike(String value) {
            addCriterion("acc_type like", value, "accType");
            return (Criteria) this;
        }

        public Criteria andAccTypeNotLike(String value) {
            addCriterion("acc_type not like", value, "accType");
            return (Criteria) this;
        }

        public Criteria andAccTypeIn(List<String> values) {
            addCriterion("acc_type in", values, "accType");
            return (Criteria) this;
        }

        public Criteria andAccTypeNotIn(List<String> values) {
            addCriterion("acc_type not in", values, "accType");
            return (Criteria) this;
        }

        public Criteria andAccTypeBetween(String value1, String value2) {
            addCriterion("acc_type between", value1, value2, "accType");
            return (Criteria) this;
        }

        public Criteria andAccTypeNotBetween(String value1, String value2) {
            addCriterion("acc_type not between", value1, value2, "accType");
            return (Criteria) this;
        }

        public Criteria andDcFlagIsNull() {
            addCriterion("dc_flag is null");
            return (Criteria) this;
        }

        public Criteria andDcFlagIsNotNull() {
            addCriterion("dc_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDcFlagEqualTo(String value) {
            addCriterion("dc_flag =", value, "dcFlag");
            return (Criteria) this;
        }

        public Criteria andDcFlagNotEqualTo(String value) {
            addCriterion("dc_flag <>", value, "dcFlag");
            return (Criteria) this;
        }

        public Criteria andDcFlagGreaterThan(String value) {
            addCriterion("dc_flag >", value, "dcFlag");
            return (Criteria) this;
        }

        public Criteria andDcFlagGreaterThanOrEqualTo(String value) {
            addCriterion("dc_flag >=", value, "dcFlag");
            return (Criteria) this;
        }

        public Criteria andDcFlagLessThan(String value) {
            addCriterion("dc_flag <", value, "dcFlag");
            return (Criteria) this;
        }

        public Criteria andDcFlagLessThanOrEqualTo(String value) {
            addCriterion("dc_flag <=", value, "dcFlag");
            return (Criteria) this;
        }

        public Criteria andDcFlagLike(String value) {
            addCriterion("dc_flag like", value, "dcFlag");
            return (Criteria) this;
        }

        public Criteria andDcFlagNotLike(String value) {
            addCriterion("dc_flag not like", value, "dcFlag");
            return (Criteria) this;
        }

        public Criteria andDcFlagIn(List<String> values) {
            addCriterion("dc_flag in", values, "dcFlag");
            return (Criteria) this;
        }

        public Criteria andDcFlagNotIn(List<String> values) {
            addCriterion("dc_flag not in", values, "dcFlag");
            return (Criteria) this;
        }

        public Criteria andDcFlagBetween(String value1, String value2) {
            addCriterion("dc_flag between", value1, value2, "dcFlag");
            return (Criteria) this;
        }

        public Criteria andDcFlagNotBetween(String value1, String value2) {
            addCriterion("dc_flag not between", value1, value2, "dcFlag");
            return (Criteria) this;
        }

        public Criteria andMinusFlagIsNull() {
            addCriterion("minus_flag is null");
            return (Criteria) this;
        }

        public Criteria andMinusFlagIsNotNull() {
            addCriterion("minus_flag is not null");
            return (Criteria) this;
        }

        public Criteria andMinusFlagEqualTo(String value) {
            addCriterion("minus_flag =", value, "minusFlag");
            return (Criteria) this;
        }

        public Criteria andMinusFlagNotEqualTo(String value) {
            addCriterion("minus_flag <>", value, "minusFlag");
            return (Criteria) this;
        }

        public Criteria andMinusFlagGreaterThan(String value) {
            addCriterion("minus_flag >", value, "minusFlag");
            return (Criteria) this;
        }

        public Criteria andMinusFlagGreaterThanOrEqualTo(String value) {
            addCriterion("minus_flag >=", value, "minusFlag");
            return (Criteria) this;
        }

        public Criteria andMinusFlagLessThan(String value) {
            addCriterion("minus_flag <", value, "minusFlag");
            return (Criteria) this;
        }

        public Criteria andMinusFlagLessThanOrEqualTo(String value) {
            addCriterion("minus_flag <=", value, "minusFlag");
            return (Criteria) this;
        }

        public Criteria andMinusFlagLike(String value) {
            addCriterion("minus_flag like", value, "minusFlag");
            return (Criteria) this;
        }

        public Criteria andMinusFlagNotLike(String value) {
            addCriterion("minus_flag not like", value, "minusFlag");
            return (Criteria) this;
        }

        public Criteria andMinusFlagIn(List<String> values) {
            addCriterion("minus_flag in", values, "minusFlag");
            return (Criteria) this;
        }

        public Criteria andMinusFlagNotIn(List<String> values) {
            addCriterion("minus_flag not in", values, "minusFlag");
            return (Criteria) this;
        }

        public Criteria andMinusFlagBetween(String value1, String value2) {
            addCriterion("minus_flag between", value1, value2, "minusFlag");
            return (Criteria) this;
        }

        public Criteria andMinusFlagNotBetween(String value1, String value2) {
            addCriterion("minus_flag not between", value1, value2, "minusFlag");
            return (Criteria) this;
        }

        public Criteria andMinusAmountIsNull() {
            addCriterion("minus_amount is null");
            return (Criteria) this;
        }

        public Criteria andMinusAmountIsNotNull() {
            addCriterion("minus_amount is not null");
            return (Criteria) this;
        }

        public Criteria andMinusAmountEqualTo(BigDecimal value) {
            addCriterion("minus_amount =", value, "minusAmount");
            return (Criteria) this;
        }

        public Criteria andMinusAmountNotEqualTo(BigDecimal value) {
            addCriterion("minus_amount <>", value, "minusAmount");
            return (Criteria) this;
        }

        public Criteria andMinusAmountGreaterThan(BigDecimal value) {
            addCriterion("minus_amount >", value, "minusAmount");
            return (Criteria) this;
        }

        public Criteria andMinusAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("minus_amount >=", value, "minusAmount");
            return (Criteria) this;
        }

        public Criteria andMinusAmountLessThan(BigDecimal value) {
            addCriterion("minus_amount <", value, "minusAmount");
            return (Criteria) this;
        }

        public Criteria andMinusAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("minus_amount <=", value, "minusAmount");
            return (Criteria) this;
        }

        public Criteria andMinusAmountIn(List<BigDecimal> values) {
            addCriterion("minus_amount in", values, "minusAmount");
            return (Criteria) this;
        }

        public Criteria andMinusAmountNotIn(List<BigDecimal> values) {
            addCriterion("minus_amount not in", values, "minusAmount");
            return (Criteria) this;
        }

        public Criteria andMinusAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("minus_amount between", value1, value2, "minusAmount");
            return (Criteria) this;
        }

        public Criteria andMinusAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("minus_amount not between", value1, value2, "minusAmount");
            return (Criteria) this;
        }

        public Criteria andTotalMinusAmountIsNull() {
            addCriterion("total_minus_amount is null");
            return (Criteria) this;
        }

        public Criteria andTotalMinusAmountIsNotNull() {
            addCriterion("total_minus_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalMinusAmountEqualTo(BigDecimal value) {
            addCriterion("total_minus_amount =", value, "totalMinusAmount");
            return (Criteria) this;
        }

        public Criteria andTotalMinusAmountNotEqualTo(BigDecimal value) {
            addCriterion("total_minus_amount <>", value, "totalMinusAmount");
            return (Criteria) this;
        }

        public Criteria andTotalMinusAmountGreaterThan(BigDecimal value) {
            addCriterion("total_minus_amount >", value, "totalMinusAmount");
            return (Criteria) this;
        }

        public Criteria andTotalMinusAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_minus_amount >=", value, "totalMinusAmount");
            return (Criteria) this;
        }

        public Criteria andTotalMinusAmountLessThan(BigDecimal value) {
            addCriterion("total_minus_amount <", value, "totalMinusAmount");
            return (Criteria) this;
        }

        public Criteria andTotalMinusAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_minus_amount <=", value, "totalMinusAmount");
            return (Criteria) this;
        }

        public Criteria andTotalMinusAmountIn(List<BigDecimal> values) {
            addCriterion("total_minus_amount in", values, "totalMinusAmount");
            return (Criteria) this;
        }

        public Criteria andTotalMinusAmountNotIn(List<BigDecimal> values) {
            addCriterion("total_minus_amount not in", values, "totalMinusAmount");
            return (Criteria) this;
        }

        public Criteria andTotalMinusAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_minus_amount between", value1, value2, "totalMinusAmount");
            return (Criteria) this;
        }

        public Criteria andTotalMinusAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_minus_amount not between", value1, value2, "totalMinusAmount");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNull() {
            addCriterion("currency is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNotNull() {
            addCriterion("currency is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyEqualTo(String value) {
            addCriterion("currency =", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotEqualTo(String value) {
            addCriterion("currency <>", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThan(String value) {
            addCriterion("currency >", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThanOrEqualTo(String value) {
            addCriterion("currency >=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThan(String value) {
            addCriterion("currency <", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThanOrEqualTo(String value) {
            addCriterion("currency <=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLike(String value) {
            addCriterion("currency like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotLike(String value) {
            addCriterion("currency not like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyIn(List<String> values) {
            addCriterion("currency in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotIn(List<String> values) {
            addCriterion("currency not in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyBetween(String value1, String value2) {
            addCriterion("currency between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotBetween(String value1, String value2) {
            addCriterion("currency not between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("version not between", value1, value2, "version");
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