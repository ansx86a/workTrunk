<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html  lang="zh-Hant-TW">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=BIG5">
    <title>bootstrap title</title>
  </head>
  <body>
    <div style="position: fixed; bottom: 10px; right: 10px; width: 50px; border: 3px solid #73AD21;">
      <a href="#div0">回開頭</a>
    </div>
    <p>
      
    </p>
            <pre>
    </pre>
    <div id="div0" align="center">
      <p>
        <a href="#id1">圖示相關，圖示列表參照icons.jsp</a>
      </p>
      <p>
        <a href="#id2">下拉選單、按鈕群組</a>
      </p>
      <p>
        <a href="#id3">inputGroup</a>
      </p>
      <p>
        <a href="#id4">巡覽</a>
      </p>
      <p>
        <a href="#id5">巡覽列</a>
      </p>
      <p>
        <a href="#id6">id6</a>
      </p>
      <p>
        <a href="#id7">id7</a>
      </p>
      <p>
        <a href="#id8">id8</a>
      </p>
      <p>
        <a href="#id9">id9</a>
      </p>
      <p>
        <a href="#id10">id10</a>
      </p>
      <!-- ******************************************************************************************** -->
      <button type="button" onclick="javascriptWindow(document.getElementById('id1').value );">測試1</button>
      <br>
      <textarea id="id1" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
      spellcheck="false">
      <!DOCTYPE html>
      <html lang="zh-Hant-TW">
        <head>
          <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
          <link rel="stylesheet" type="text/css" href="../css/mycss.css">
          <script src="js/jquery-1.12.4.min.js"></script>
          <script src="js/bootstrap.min.js"></script>
        </head>
        <div class="container-fluid 單線邊框 橘色邊框">
          <div class="alert alert-success" role="alert">
            <p><b>加上btn-toolbar類別，感覺沒什麼差別，就當一種標準排版來記就好了</b></p>
            <p><b>加上btn-group類別，可以把按鈕都粘一起margin-left: 0;</b></p>
          </div>
          
          <div class="btn-toolbar" role="toolbar">
            <div class="btn-group">
              <button type="button" class="btn btn-default" aria-label="Left Align"><span class="glyphicon glyphicon-align-left" aria-hidden="true"></span></button>
              <button type="button" class="btn btn-default" aria-label="Center Align"><span class="glyphicon glyphicon-align-center" aria-hidden="true"></span></button>
              <button type="button" class="btn btn-default" aria-label="Right Align"><span class="glyphicon glyphicon-align-right" aria-hidden="true"></span></button>
              <button type="button" class="btn btn-default" aria-label="Justify"><span class="glyphicon glyphicon-align-justify" aria-hidden="true"></span></button>
            </div>
          </div>
          
          <div class="btn-toolbar" role="toolbar">
            <button type="button" class="btn btn-default btn-lg"><span class="glyphicon glyphicon-star" aria-hidden="true"></span> Star</button>
            <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-star" aria-hidden="true"></span> Star</button>
            <button type="button" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-star" aria-hidden="true"></span> Star</button>
            <button type="button" class="btn btn-default btn-xs"><span class="glyphicon glyphicon-star" aria-hidden="true"></span> Star</button>
          </div>
          展示alert加圖示
          <div class="alert alert-danger" role="alert">
            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
            <span class="sr-only">Error:</span>
            Enter a valid email address
          </div>
        </div>
        <br>
      </html>
      
      </textarea>
      <br>
      <!-- ******************************************************************************************** -->
      <button type="button" onclick="javascriptWindow(document.getElementById('id2').value );">測試2</button>
      <br>
      <textarea id="id2" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
      spellcheck="false">
      <!DOCTYPE html>
      <html lang="zh-Hant-TW">
        <head>
          <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
          <link rel="stylesheet" type="text/css" href="../css/mycss.css">
          <script src="js/jquery-1.12.4.min.js"></script>
          <script src="js/bootstrap.min.js"></script>
        </head>
        <div class="container-fluid 單線邊框 橘色邊框">
          <div class="alert alert-success" role="alert">
            <p><b>dropdown的實作，第一層為用div包起來，class用dropdown，裡面有button和ul</b></p>
            <p><b>dropdown實作為用button，內文為dorpdown字樣和一個span.caret(下箭頭)</b></p>
            <p><b>ul這一層重點是class要用dropdown-menu，menuitem實作是用a，應該可以用別的</b></p>
            <p><b>不懂dropdown-toggle類別的功用，但是文件說要加，還有data-toggle要設dropdown，就造做吧</b></p>
            <p><b>標題用dropdown-header，分隔線用divider，禁能用disabled</b></p>
            <p><b>用起來覺得怪的是點到標題或是分隔線或是禁能的選項，dropdown還是會跳掉</b></p>
            <p><b>控制dropdown的open和close好像是一門大學問，google可以查到用多有的沒的</b></p>
          </div>
          <div class="dropdown 單線邊框">
            <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
            Dropdown，右靠的用btn-group的效果好，inline-block
            <span class="caret"></span>
            </button>
            <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
              <li role="presentation" class="dropdown-header">Dropdown 標題1</li>
              <li role="presentation" class="divider"></li>
              <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Action</a></li>
              <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Another action</a></li>
              <li role="presentation" class="dropdown-header">Dropdown 標題1，不能點</li>
              <li role="presentation" class="divider"></li>
              <li role="presentation" class="disabled"><a role="menuitem" tabindex="-1" href="#">禁能的選單</a></li>
              <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Separated link</a></li>
            </ul>
            <ul class="dropdown-menu dropdown-menu-right" role="menu" aria-labelledby="dropdownMenu1">
              <li role="presentation"><a role="menuitem" tabindex="-1" href="#">右靠的效果dropdown-menu-right</a></li>
              <li role="presentation"><a role="menuitem" tabindex="-1" href="#">不推薦使用 .pull-right 對齊</a></li>
              <li role="presentation"><a role="menuitem" tabindex="-1" href="#">沒有右靠的話，會蓋過去上一個dorpdown-menu</a></li>
              <li role="presentation"><a role="menuitem" tabindex="-1" href="#">正常都只有一個dorpdown-menu，所以不會發生</a></li>
              <li role="presentation"><a role="menuitem" tabindex="-1" href="#">被上面的蓋過去的事件</a></li>
            </ul>
          </div>
          
          
        </div>
        <br>
        <div class="container-fluid 單線邊框 橘色邊框">
          <div class="alert alert-success" role="alert">
            <p><b>加上btn-group類別，可以把按鈕都粘一起margin-left: 0;</b></p>
            <p><b>加上btn-toolbar類別，應該只是排版，把多組btn-group隔開</b></p>
          </div>
          
          最簡單的btn-group的展示
          <div class="btn-group" role="group" aria-label="...">
            <button type="button" class="btn btn-default">Left</button>
            <button type="button" class="btn btn-default">Middle</button>
            <button type="button" class="btn btn-default">Right</button>
          </div>
          btn-toolbar的展示
          <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
            <div class="btn-group" role="group" aria-label="First group">
              <button type="button" class="btn btn-default">1</button>
              <button type="button" class="btn btn-default">2</button>
              <button type="button" class="btn btn-default">3</button>
              <button type="button" class="btn btn-default">4</button>
            </div>
            <div class="btn-group" role="group" aria-label="Second group">
              <button type="button" class="btn btn-default">5</button>
              <button type="button" class="btn btn-default">6</button>
              <button type="button" class="btn btn-default">7</button>
            </div>
            <div class="btn-group" role="group" aria-label="Third group">
              <button type="button" class="btn btn-default">8</button>
            </div>
          </div>
          
          大型的btn-group-lg
          <div class="btn-group btn-group-lg" role="group" aria-label="Large button group">
            <button type="button" class="btn btn-default">Left</button>
            <button type="button" class="btn btn-default">Middle</button>
            <button type="button" class="btn btn-default">Right</button>
          </div>
          <br>
          一般的default大小
          <div class="btn-group" role="group" aria-label="Default button group">
            <button type="button" class="btn btn-default">Left</button>
            <button type="button" class="btn btn-default">Middle</button>
            <button type="button" class="btn btn-default">Right</button>
          </div>
          <br>
          小型的btn-group-sm
          <div class="btn-group btn-group-sm" role="group" aria-label="Small button group">
            <button type="button" class="btn btn-default">Left</button>
            <button type="button" class="btn btn-default">Middle</button>
            <button type="button" class="btn btn-default">Right</button>
          </div>
          <br>
          超小型的btn-group-xs
          <div class="btn-group btn-group-xs" role="group" aria-label="Extra-small button group">
            <button type="button" class="btn btn-default">Left</button>
            <button type="button" class="btn btn-default">Middle</button>
            <button type="button" class="btn btn-default">Right</button>
          </div>
          <br>
          垂直排列btn-group-vertical，原理是外層div變inline-block，裡面的button變block
          <br>
          <div class="btn-group-vertical" role="group" >
            <button type="button" class="btn btn-default">Left</button>
            <button type="button" class="btn btn-default">Middle</button>
            <button type="button" class="btn btn-default">Right</button>
          </div>
          <p>填滿水平的佈局 btn-group-justified，原理是先把寬度變100%，內部的連結用css的table佈局</p>
          <div class="btn-group btn-group-justified" role="group" aria-label="Justified button group">
            <a href="#" class="btn btn-default" role="button">Left</a>
            <a href="#" class="btn btn-default" role="button">Middle</a>
            <a href="#" class="btn btn-default" role="button">Right</a>
          </div>
          <p>同上，只是用button來實作，要包一堆btn-group(才能平分大小)有點麻煩</p>
          <div class="btn-group btn-group-justified" role="group" aria-label="Justified button group">
            <div class="btn-group" role="group">
              <button type="button" class="btn btn-default">Left</button>
            </div>
            <div class="btn-group" role="group">
              <button type="button" class="btn btn-default">Middle</button>
            </div>
            <div class="btn-group" role="group">
              <button type="button" class="btn btn-default">Right</button>
            </div>
          </div>
        </div>
        <br>
        <div class="container-fluid 單線邊框 橘色邊框">
          <div class="alert alert-success" role="alert">
            <p><b>button加dropdown的組合</b></p>
          </div>
       button下拉選單，原本是用button的本文包text+span來實作，下面改成用btn-group來連結兩個button，第一個button取代text，第2個button包span來實作下拉的部分   
      <div class="btn-group">
      <button type="button" class="btn btn-primary">Primary</button>
      <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
        <span class="caret"></span>
        <span class="sr-only">Toggle Dropdown</span>
      </button>
      <ul class="dropdown-menu" role="menu">
        <li><a href="#">Action</a></li>
        <li><a href="#">Another action</a></li>
        <li><a href="#">Something else here</a></li>
        <li class="divider"></li>
        <li><a href="#">Separated link</a></li>
      </ul>
    </div>
       <br>
             
    <br>
      官網的範例class="btn-group"，修改裡面的btn的大小，回復本來的dropdown的做法
    ，特別要注意的是，本來div的class由dropdown改成了btn-group，跑起來的感覺是完全相同
   <div class="btn-group">
        <button class="btn btn-primary btn-lg dropdown-toggle" type="button" data-toggle="dropdown" aria-expanded="false">
          Large button <span class="caret"></span>
        </button>
        <ul class="dropdown-menu" role="menu">
          <li><a href="https://kkbruce.tw/bs3/Components#">Action</a></li>
          <li><a href="https://kkbruce.tw/bs3/Components#">Another action</a></li>
          <li><a href="https://kkbruce.tw/bs3/Components#">Something else here</a></li>
          <li class="divider"></li>
          <li><a href="https://kkbruce.tw/bs3/Components#">Separated link</a></li>
        </ul>
      </div>
    class="dropdown"對照組，我想只要有position: relative;即可，而btn-group也有此設定
<div class="dropdown">
        <button class="btn btn-primary btn-lg dropdown-toggle" type="button" data-toggle="dropdown" aria-expanded="false">
          Large button <span class="caret"></span>
        </button>
        <ul class="dropdown-menu" role="menu">
          <li><a href="https://kkbruce.tw/bs3/Components#">Action</a></li>
          <li><a href="https://kkbruce.tw/bs3/Components#">Another action</a></li>
          <li><a href="https://kkbruce.tw/bs3/Components#">Something else here</a></li>
          <li class="divider"></li>
          <li><a href="https://kkbruce.tw/bs3/Components#">Separated link</a></li>
        </ul>
      </div>      
    往上彈dropup，好像沒有右彈或是左彈
<div class="btn-group dropup">
        <button type="button" class="btn btn-primary">Right dropup</button>
        <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
          <span class="caret"></span>
          <span class="sr-only">Toggle Dropdown</span>
        </button>
        <ul class="dropdown-menu dropdown-menu-right" role="menu">
          <li><a href="#">Action</a></li>
          <li><a href="#">Another action</a></li>
          <li><a href="#">Something else here</a></li>
          <li class="divider"></li>
          <li><a href="#">Separated link</a></li>
        </ul>
      </div>
    
        </div>
        <br>        
        
        
      </html>
      
      
      
      </textarea>
      <br>
      <!-- ******************************************************************************************** -->
      <button type="button" onclick="javascriptWindow(document.getElementById('id3').value );">測試3</button>
      <br>
      <textarea id="id3" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
      spellcheck="false">
      <!DOCTYPE html>
      <html lang="zh-Hant-TW">
        <head>
          <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
          <link rel="stylesheet" type="text/css" href="../css/mycss.css">
          <script src="js/jquery-1.12.4.min.js"></script>
          <script src="js/bootstrap.min.js"></script>
        </head>
        <div class="container-fluid 單線邊框 橘色邊框">
          <div class="alert alert-success" role="alert">
            <p><b>透過在基於文字的 input 元素之前、之後或兩邊加入文字或 button 以擴充 form 控制項。
            為 .input-group 加入 .input-group-addon 類別，可以讓 .form-control 的前面或後面額外加入其他元素。</b></p>
          </div>
          div用input-group，內容用span(input-group-addon)+text(form-control)
          <div class="input-group">
  <span class="input-group-addon">@</span>
  <input type="text" class="form-control" placeholder="Username">
</div>

<div class="input-group">
  <input type="text" class="form-control">
  <span class="input-group-addon">.00</span>
</div>

<div class="input-group">
  <span class="input-group-addon">$</span>
  <input type="text" class="form-control">
  <span class="input-group-addon">.00</span>
</div>
         <hr>
         同上例，只是加入了大小的調整<br>
         大型:input-group-lg
<div class="input-group input-group-lg">
  <span class="input-group-addon">@</span>
  <input type="text" class="form-control" placeholder="Username">
</div>
預設大小
<div class="input-group">
  <span class="input-group-addon">@</span>
  <input type="text" class="form-control" placeholder="Username">
</div>
小型:input-group-lg
<div class="input-group input-group-sm">
  <span class="input-group-addon">@</span>
  <input type="text" class="form-control" placeholder="Username">
</div>         
         
以下範例是用grid大螢幕 6-6分，放2個input-group，附加span放checkbox和radio          
<div class="row">
  <div class="col-lg-6">
    <div class="input-group">
      <span class="input-group-addon">
        <input type="checkbox">
      </span>
      <input type="text" class="form-control">
    </div><!-- /input-group -->
  </div><!-- /.col-lg-6 -->
  <div class="col-lg-6">
    <div class="input-group">
      <span class="input-group-addon">
        <input type="radio">
      </span>
      <input type="text" class="form-control">
    </div><!-- /input-group -->
  </div><!-- /.col-lg-6 -->
</div><!-- /.row -->          

同上，改放button而已          
<div class="row">
  <div class="col-lg-6">
    <div class="input-group">
      <span class="input-group-btn">
        <button class="btn btn-default" type="button">Go!</button>
      </span>
      <input type="text" class="form-control">
    </div><!-- /input-group -->
  </div><!-- /.col-lg-6 -->
  <div class="col-lg-6">
    <div class="input-group">
      <input type="text" class="form-control">
      <span class="input-group-btn">
        <button class="btn btn-default" type="button">Go!</button>
      </span>
    </div><!-- /input-group -->
  </div><!-- /.col-lg-6 -->
</div><!-- /.row -->          
          
同上，改成了dropdown而已，注意的是dropdown div的class用input-group-btn          
<div class="row">
  <div class="col-lg-6">
    <div class="input-group">
      <div class="input-group-btn">
        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">Action <span class="caret"></span></button>
        <ul class="dropdown-menu" role="menu">
          <li><a href="#">Action</a></li>
          <li><a href="#">Another action</a></li>
          <li><a href="#">Something else here</a></li>
          <li class="divider"></li>
          <li><a href="#">Separated link</a></li>
        </ul>
      </div><!-- /btn-group -->
      <input type="text" class="form-control">
    </div><!-- /input-group -->
  </div><!-- /.col-lg-6 -->
  <div class="col-lg-6">
    <div class="input-group">
      <input type="text" class="form-control">
      <div class="input-group-btn">
        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">Action <span class="caret"></span></button>
        <ul class="dropdown-menu dropdown-menu-right" role="menu">
          <li><a href="#">Action</a></li>
          <li><a href="#">Another action</a></li>
          <li><a href="#">Something else here</a></li>
          <li class="divider"></li>
          <li><a href="#">Separated link</a></li>
        </ul>
      </div><!-- /btn-group -->
    </div><!-- /input-group -->
  </div><!-- /.col-lg-6 -->
</div><!-- /.row -->          
          
同上，只是dropdown btn改成下三角，前面再加了一個button，特別注意的是button是連在一起的<br> 
.input-group-btn:last-child>.btn, {margin-left: -1px;}<br>
有需要時可能要用btn-group來把button連在一起
         
<div class="row">
      <div class="col-lg-6">
        <div class="input-group">
          <div class="input-group-btn">
            <button type="button" class="btn btn-default" tabindex="-1">Action</button>
            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
              <span class="caret"></span>
              <span class="sr-only">Toggle Dropdown</span>
            </button>
            <ul class="dropdown-menu" role="menu">
              <li><a href="#">Action</a></li>
              <li><a href="#">Another action</a></li>
              <li><a href="#">Something else here</a></li>
              <li class="divider"></li>
              <li><a href="#">Separated link</a></li>
            </ul>
          </div>
          <input type="text" class="form-control">
        </div><!-- /.input-group -->
      </div><!-- /.col-lg-6 -->
      <div class="col-lg-6">
        <div class="input-group">
          <input type="text" class="form-control">
          <div class="input-group-btn">
            <button type="button" class="btn btn-default" tabindex="-1">Action</button>
            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
              <span class="caret"></span>
              <span class="sr-only">Toggle Dropdown</span>
            </button>
            <ul class="dropdown-menu dropdown-menu-right" role="menu">
              <li><a href="#">Action</a></li>
              <li><a href="#">Another action</a></li>
              <li><a href="#">Something else here</a></li>
              <li class="divider"></li>
              <li><a href="#">Separated link</a></li>
            </ul>
          </div>
        </div><!-- /.input-group -->
      </div><!-- /.col-lg-6 -->
    </div>          
        </div>
        <br>
      </html>      
      </textarea>
      <br>
      <!-- ******************************************************************************************** -->
      <button type="button" onclick="javascriptWindow(document.getElementById('id4').value );">測試4</button>
      <br>
      <textarea id="id4" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
      spellcheck="false">
<!DOCTYPE html>
      <html lang="zh-Hant-TW">
        <head>
          <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
          <link rel="stylesheet" type="text/css" href="../css/mycss.css">
          <script src="js/jquery-1.12.4.min.js"></script>
          <script src="js/bootstrap.min.js"></script>
        </head>
        <div class="container-fluid 單線邊框 橘色邊框">
          <div class="alert alert-success" role="alert">
            <p><b>nav類別，用來取消列表的樣式和間距，padding-left: 0;margin-bottom: 0;list-style: none;(>li position: relative;display: block;) >li>a...</b></p>
            <p><b>nav-tabs類別，設底線和右靠，border-bottom: 1px solid #ddd;(>li float: left;margin-bottom: -1px;) >li>a...</b></p>
            <p><b>nav-stacked類別，回覆垂直排列而已，.nav-stacked>li {float: none;}</b></p>
          </div>
          最簡單的基本樣式nav-tabs
          <ul class="nav nav-tabs">
  <li role="presentation" class="active"><a href="#">Home</a></li>
  <li role="presentation"><a href="#">Profile</a></li>
  <li role="presentation"><a href="#">Messages</a></li>
</ul>
        <hr>  
          藥片樣式nav-pills，影嚮到active類別的顯示
          <ul class="nav nav-pills">
  <li role="presentation" class="active"><a href="#">Home</a></li>
  <li role="presentation"><a href="#">Profile</a></li>
  <li role="presentation"><a href="#">Messages</a></li>
</ul>
                <hr>  
藥片+垂直佈局
<ul class="nav nav-pills nav-stacked" style="max-width: 300px;">
      <li role="presentation" class="active"><a href="#">Home</a></li>
      <li role="presentation"><a href="#">Profile</a></li>
      <li role="presentation"><a href="#">Messages</a></li>
    </ul>          
          <hr>
平分的佈局nav-justified，實作方式應該是用css的table佈局吧          
<ul class="nav nav-pills nav-justified">
      <li role="presentation" class="active"><a href="#">Home</a></li>
      <li role="presentation"><a href="#">Profile</a></li>
      <li role="presentation"><a href="#">Messages</a></li>
    </ul>          
          <hr>
          disabled的樣式，但是功能仍然在，可以撰寫 JavaScript 以禁用這裡的連結
<ul class="nav nav-pills">
      <li role="presentation"><a href="#">Clickable link</a></li>
      <li role="presentation"><a href="#">Clickable link</a></li>
      <li role="presentation" class="disabled"><a href="#" >Disabled link</a></li>
    </ul>          
<hr>
有dropdown的nav，重點是li有class用dropdown，而dropdown的btn改成用a包text和span
<br>dropdown的第一層的href好像沒什麼用，或許可以拿掉
<ul class="nav nav-tabs">
      <li role="presentation" class="active"><a href="https://kkbruce.tw/bs3/Components#">Home</a></li>
      <li role="presentation"><a href="https://kkbruce.tw/bs3/Components#">Help</a></li>
      <li role="presentation" class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="https://kkbruce.tw/bs3/Components#/設這個好像沒什麼用，或許可以拿掉吧" role="button" aria-expanded="false">
          Dropdown <span class="caret"></span>
        </a>
        <ul class="dropdown-menu" role="menu">
          <li><a href="https://kkbruce.tw/bs3/Components#">Action</a></li>
          <li><a href="https://kkbruce.tw/bs3/Components#">Another action</a></li>
          <li><a href="https://kkbruce.tw/bs3/Components#">Something else here</a></li>
          <li class="divider"></li>
          <li><a href="https://kkbruce.tw/bs3/Components#">Separated link</a></li>
        </ul>
      </li>
    </ul>
        </div>
        <br>
      </html>
      </textarea>
      <br>
      <!-- ******************************************************************************************** -->
      <button type="button" onclick="javascriptWindow(document.getElementById('id5').value );">測試5</button>
      <br>
      <textarea id="id5" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
      spellcheck="false">
      <!DOCTYPE html>
      <html lang="zh-Hant-TW">
        <head>
          <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
          <link rel="stylesheet" type="text/css" href="../css/mycss.css">
          <script src="js/jquery-1.12.4.min.js"></script>
          <script src="js/bootstrap.min.js"></script>
        </head>
        <div class="container-fluid 單線邊框 橘色邊框">
          <div class="alert alert-success" role="alert">
            <p><b>注意nav是ie9之後才能用</b></p>
            <p><b>navbar類別，設大小和邊框， position: relative;min-height: 50px;margin-bottom: 20px;border: 1px solid transparent;</b></p>
            <p><b>navbar-default類別，設顏色，background-color: #f8f8f8;border-color: #e7e7e7;</b></p>
            <p><b>navbar-header類別，設靠左，float: left;</b></p>
            <p><b>navbar-brand類別，設靠左和高、字大小，float: left;height: 50px;padding: 15px 15px;font-size: 18px;line-height: 20px;</b></p>
          </div>


在navbar-header的div，放一個商標圖連結class為navbar-brand
<nav class="navbar navbar-default" role="navigation">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="https://kkbruce.tw/bs3/Components#">
            <img alt="Brand" height="20" src="data:image/png;base64,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">
          </a>
        </div>
      </div>
    </nav>
<hr>
重點是navbar-header裡的button，在768px以下display:none，用來把nav的detail弄成dropdown
<nav class="navbar navbar-default" role="navigation">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="https://kkbruce.tw/bs3/Components#">Brand</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
          <form class="navbar-form navbar-left" role="search">
            <div class="form-group">
              <input type="text" class="form-control" placeholder="Search">
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
          </form>
        </div>
      </div>
    </nav>
<hr>
沒有在form中的button，加入navbar-btn來排版.navbar-btn {    margin-top: 8px;    margin-bottom: 8px;}
<br>text用p包起來後，class用navbar-text，768px以上float: left;margin-right: 15px;margin-left: 15px;
<nav class="navbar navbar-default" role="navigation">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-3">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="https://kkbruce.tw/bs3/Components#">Brand</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-3">
          <p class="navbar-text">文字用p包起來</p>
          <p class="navbar-text">拿掉class排序會錯亂</p>
          <button type="button" class="btn btn-default navbar-btn">Sign in</button>
          <button type="button" class="btn btn-default">Sign in對照組，上下都大8px吧</button>
        </div>
      </div>
    </nav>
<hr>
這個例子有點太難，晚點再來看          
<nav class="navbar navbar-default" role="navigation">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Brand</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
        <li><a href="#">Link</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Dropdown <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li class="divider"></li>
            <li><a href="#">Separated link</a></li>
            <li class="divider"></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li>
      </ul>
      <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">Link</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Dropdown <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li class="divider"></li>
            <li><a href="#">Separated link</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
          
        </div>
        <br>
        
        
        
      </html>
      </textarea>
      <br>
      <!-- ******************************************************************************************** -->
      <button type="button" onclick="javascriptWindow(document.getElementById('id6').value );">測試6</button>
      <br>
      <textarea id="id6" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
      spellcheck="false">
      </textarea>
      <br>
      <!-- ******************************************************************************************** -->
      <button type="button" onclick="javascriptWindow(document.getElementById('id7').value );">測試7</button>
      <br>
      <textarea id="id7" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
      spellcheck="false">
      </textarea>
      <br>
      <!-- ******************************************************************************************** -->
      <button type="button" onclick="javascriptWindow(document.getElementById('id8').value );">測試8</button>
      <br>
      <textarea id="id8" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
      spellcheck="false">
      </textarea>
      <br>
      <!-- ******************************************************************************************** -->
      <button type="button" onclick="javascriptWindow(document.getElementById('id9').value );">測試9</button>
      <br>
      <textarea id="id9" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
      spellcheck="false">
      <script>
      
      </script>
      </textarea>
      <br>
      <!-- ******************************************************************************************** -->
      <button type="button" onclick="javascriptWindow(document.getElementById('id10').value );">測試10</button>
      <br>
      <textarea id="id10" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
      spellcheck="false">
      <script>
      
      </script>
      </textarea>
      <br>
      <!-- ******************************************************************************************** -->
      <button type="button" onclick="javascriptWindow(document.getElementById('id11').value );">測試11</button>
      <br>
      <textarea id="id11" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
      spellcheck="false">
      <!DOCTYPE html>
      <html lang="zh-Hant-TW">
        <head>
          <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
          <link rel="stylesheet" type="text/css" href="../css/mycss.css">
          <script src="js/jquery-1.12.4.min.js"></script>
          <script src="js/bootstrap.min.js"></script>
        </head>
        <div class="container-fluid 單線邊框 橘色邊框">
          <div class="alert alert-success" role="alert">
            <p><b>aaaaaaaaaaaaaaaaa</b></p>
          </div>
        </div>
        <br>
        
        
      </html>
      
      </textarea>
      <br>
    </div>
  </body>
  <script>
  function javascriptWindow(txt) {
  開新視窗: {
  var x = screen.width / 2 - 600 / 2;
  var y = screen.height / 2 - 500 / 2;
  var w = window.open("", "", "scrollbars=1;width=600,height=500,left=" + x + ",top=" + y);
  w.document.open();
  w.document.write(txt);
  w.document.close();
  }
  }
  </script>
</html>