Hello world
變數name = ${name}

注意boolean 不能直接印出來，還是要轉成string如下
<#if thisIsTrue>顯示this is true ${thisIsTrue?string('真','假')} </#if>
<#if !thisIsTrue>不顯示this is true  ${thisIsTrue?string('真','假')}
<#else>不輸出 !thisIsTrue
</#if>
<#if thisIsFalse>不顯示this is false  ${thisIsFalse?string('真','假')}
<#else>不輸出 thisIsFalse
</#if>
<#if !thisIsFalse>顯示this is false  ${thisIsFalse?string('真','假')}</#if>
