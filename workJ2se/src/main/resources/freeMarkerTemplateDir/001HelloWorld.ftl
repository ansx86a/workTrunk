<html>
Hello world
變數name = ${name}
==========================================================================
測試#if的寫法
注意boolean 不能直接印出來，還是要轉成string如下
<#if thisIsTrue>顯示this is true ${thisIsTrue?string('真','假')} </#if>
<#if !thisIsTrue>不顯示this is true  ${thisIsTrue?string('真','假')}
<#else>不輸出 !thisIsTrue
</#if>
<#if thisIsFalse>不顯示this is false  ${thisIsFalse?string('真','假')}
<#else>不輸出 thisIsFalse
</#if>
<#if !thisIsFalse>顯示this is false  ${thisIsFalse?string('真','假')}</#if>
=========================================================================
測試#list的寫法1
<#list keyList as key>
列印這行？：列印次數為keyList次數
鍵：${key.key} , 值：${key.value}
</#list>
=========================================================================
測試#list的寫法2
<#list keyList>
列印這行？：keyList為空時不列印，大於0時會列印一次，寫法1就像直接用items一樣，寫法2只在items跑迴圈
    <#items as key>
        鍵：${key.key} , 值：${key.value}
    </#items>
</#list>
==========================================================================
測試#list的寫法3，加入分隔符號如join的功能
全部的鍵：<#list keyList as key>${key.key}<#sep>|分隔|</#sep></#list>
全部的鍵(#sep可以自動補結尾)：<#list keyList as key>${key.key}<#sep>|分隔|</#list>
==========================================================================
測試#include
<#include "/forInclude.txt">
==========================================================================
測試內建函數
數字顯示：${1?string.number}
boolean顯示：${true?string("真","假")}
字串轉html："&<>/"?html=======>${"&<>/"?html}
轉大寫："abc"?upper_case=======>${"abc"?upper_case}
首字轉大寫："abc"?cap_first=======>${"abc"?cap_first}
字數："abc"?length=======>${"abc"?length}
list數量 keyList?size=======>${keyList?size} ，好像不能直接用keyList.size
list的index由0開始：<#list keyList as key>${key?index}<#sep>,</#list>
list的index由1開始：<#list keyList as key>${key?counter}<#sep>,</#list>
list的奇偶值：<#list keyList as key>${key?item_parity}<#sep>,</#list>
list的奇偶值2：<#list keyList as key>${(key?item_parity == "odd")?string("true","false")}<#sep>,</#list>
list的奇偶值3：<#list keyList as key>${key?item_cycle("true","false")}<#sep>,</#list>
全部的值join：${keyList?join("||")}
判斷字首為JJ：jjj?starts_with("JJ") -> ${"jjj"?starts_with("JJ")?string("true","false")}
判斷字首為JJ：JJJ?starts_with("JJ") -> ${"JJJ"?starts_with("JJ")?string("true","false")}
處理不存在的變數xxxBean：${xxxBean!"不存在"}
處理不存在的變數in tag：<#if xxxBean??>xxxBean存在</#if>，<#if keyList??>keyList存在</#if>


<div id="div1">div1</div>
<div id="div1">div2</div>
</html>