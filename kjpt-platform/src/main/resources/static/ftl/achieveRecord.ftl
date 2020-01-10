<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

<style type="text/css">

  * {
    padding: 0;
    margin: 0;
  }

  body {
    font-family: SimSun;
    font-size:14px;
    table-layout:fixed;
    word-wrap:break-word;
  }

  .wrap {
    width: 800px;
    margin: 0 auto;
    border: 1px solid #ccc;
  }

  table {
    margin: 0 24px;
    float: inherit;
    width: calc(100% - 48px);
  }
  .wrap table:last-of-type{
    margin-bottom: 24px;
  }

  h3 {
    padding-top: 32px;
  }

  tr td {
    padding: 4px 4px;
    min-width: 56px;
  }

  tr td.auto-no {
    height: 20px;
  }
</style>
</head>
<body>
  <div class="wrap">
    <table border="0" align="left" cellspacing='0' cellpadding='0'>
      <tr>
        <td align="left">
          <h3>科技成果基本信息</h3>
        </td>
      </tr>
      <tr>
        <td align="left">密集：${achieveRecord.secretLevelText?if_exists}</td>
      </tr>
      <tr>
        <td align="left">成果名称：${achieveRecord.achieveName?if_exists}</td>
      </tr>
      <tr>
        <td align="left">是否成为集团公司核心技术成果：${achieveRecord.achieveTypeText?if_exists}</td>
      </tr>
      <tr>
        <td align="left">成果完成单位：${achieveRecord.finishUnitName?if_exists}</td>
      </tr>
      <tr>
        <td align="left">成果转化状态：${achieveRecord.achieveTransStatusText?if_exists}</td>
      </tr>
      <tr>
        <td align="left">经费支持渠道：${achieveRecord.projectChannel?if_exists}</td>
      </tr>
      <tr>
        <td align="left">项目来源：${achieveRecord.projectSource?if_exists}</td>
      </tr>
      <tr>
        <td align="left">知识产权情况：${achieveRecord.intellectualInfo?if_exists}</td>
      </tr>
      <tr>
        <td align="left">科技成果完成团队情况（按贡献度排序）:</td>
      </tr>
      <tr>
        <table border="1" align="left" cellspacing='0' cellpadding='0'>
          <tr>
            <td class="auto-no">名称</td>
            <td class="auto-no">性别</td>
            <td class="auto-no">所在单位</td>
            <td class="auto-no">职务和贡献</td>
          </tr>
		  <#list achieveRecord.teamPerson?split("$") as person>
				<tr>
				<#assign recordPerson=person?split("#")>
                        <td class="auto-no">${recordPerson[0]?if_exists}</td>
						<#if recordPerson[1] == "1">
								<td class="auto-no">男</td>
							<#else>
								<td class="auto-no">女</td>
						</#if>
						<td class="auto-no">${recordPerson[2]?if_exists}</td>
						<td class="auto-no">${recordPerson[3]?if_exists}</td>

                </tr>
            </#list>
        </table>
      </tr>
    </table>
    <table border="0" align="left" cellspacing='0' cellpadding='0'>
      <tr>
        <td align="left">
          <h3>成果受让单位情况</h3>
        </td>
      </tr>
      <tr>
        <td align="left">单位基本信息：${achieveRecord.grantUnitName?if_exists}</td>
      </tr>
      <tr>
        <td align="left">选择单位的方式和理由：${achieveRecord.grantChooseWay?if_exists}</td>
      </tr>
      <tr>
        <td align="left">对受让单位的尽职调查情况：${achieveRecord.grantInvest?if_exists}</td>
      </tr>
      <tr>
        <td align="left">选择单位的原因：${achieveRecord.grantReason?if_exists}</td>
      </tr>
    </table>

    <table border="0" align="left" cellspacing='0' cellpadding='0'>
      <tr>
        <td align="left">
          <h3>成果转化价格确定</h3>
        </td>
      </tr>
      <tr>
        <td align="left">成果转化方式：${achieveRecord.achieveTransTypeText?if_exists}</td>
      </tr>
      <tr>
        <td align="left">定价原则和依据：${achieveRecord.transPriceBasis?if_exists}</td>
      </tr>
      <tr>
        <td align="left">定价方式（含价值评估）：${achieveRecord.transPriceWay?if_exists}</td>
      </tr>
    </table>

    <table border="0" align="left" cellspacing='0' cellpadding='0'>
      <tr>
        <td align="left">
          <h3>本单位内部决策情况</h3>
        </td>
      </tr>
      <tr>
        <td align="left">内部决策流程：${achieveRecord.decisionFlow?if_exists}</td>
      </tr>
      <tr>
        <td align="left">决策事项和结果：${achieveRecord.decisionResult?if_exists}</td>
      </tr>

    </table>

<#list achieveRecord.achieveRewards as achieveReward>
    <table border="0" align="left" cellspacing='0' cellpadding='0'>
      <tr>
        <td align="left">
          <h3>转化净收益及激励方案${achieveReward.rewardYear?if_exists}</h3>
        </td>
      </tr>
      <tr>
        <td align="left">转化收入：${achieveReward.transIncome?if_exists}</td>
      </tr>
      <tr>
        <td align="left">成果核算及核算依据：${achieveReward.checkBasis?if_exists}</td>
      </tr>
      <tr>
        <td align="left">项目全周期净收入计算：${achieveReward.incomeCalculation?if_exists}</td>
      </tr>
      <tr>
        <td align="left">项目全周期激励方案及制定方案的原则和依据：${achieveReward.rewardRecord?if_exists}</td>
      </tr>
      <tr>
        <td align="left">激励额度：${achieveReward.budgetAllMoney?if_exists}</td>
      </tr>
      <tr>
        <td align="left">工资总额预算来源：${achieveReward.budgetSources?if_exists}</td>
      </tr>
      <tr>
        <td align="left">激励总和：${achieveReward.budgetAllMoney?if_exists}</td>
      </tr>
      <tr>
        <td align="left">激励分配方案：${achieveReward.assignPlan?if_exists}</td>
      </tr>
      <tr>
        <td align="left">激励年度：${achieveReward.rewardYear?if_exists}</td>
      </tr>
      <tr>
        <td align="left">激励人员名单：</td>
      </tr>
      <tr>
        <table border="1" align="left" cellspacing='0' cellpadding='0'>
          <tr>
            <td class="auto-no">名称</td>
            <td class="auto-no">性别</td>
            <td class="auto-no">所在单位</td>
            <td class="auto-no">职务和贡献</td>
          </tr>
		  <#list achieveReward.teamPerson?split("$") as achieveRewardPerson>
                <tr>
				<#assign rewardPerson=achieveRewardPerson?split("#")>
                        <td class="auto-no">${rewardPerson[0]?if_exists}</td>
						<#if rewardPerson[1] == "1">
								<td class="auto-no">男</td>
							<#else>
								<td class="auto-no">女</td>
						</#if>
						<td class="auto-no">${rewardPerson[2]?if_exists}</td>
						<td class="auto-no">${rewardPerson[3]?if_exists}</td>

                </tr>
            </#list>
        </table>
      </tr>
    </table>
 </#list>
  </div>

</body>

</html>
