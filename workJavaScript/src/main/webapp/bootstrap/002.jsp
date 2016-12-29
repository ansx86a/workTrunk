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
        <a href="#id6">麵包屑巡覽，分頁巡覽</a>
      </p>
      <p>
        <a href="#id7">標籤、大螢幕</a>
      </p>
      <p>
        <a href="#id8">縮圖樣式</a>
      </p>
      <p>
        <a href="#id9">警告、進度條</a>
      </p>
      <p>
        <a href="#id10">媒體物件</a>
      </p>
      <p>
        <a href="#id11">id11</a>
      </p>
      <p>
        <a href="#id12">id12</a>
      </p>
      <p>
        <a href="#id13">id13</a>
      </p>
      <p>
        <a href="#id14">id14</a>
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
              </div>
            </div>
            <div class="col-lg-6">
              <div class="input-group">
                <span class="input-group-addon">
                  <input type="radio">
                </span>
                <input type="text" class="form-control">
              </div>
            </div>
          </div>
          同上，改放button而已
          <div class="row">
            <div class="col-lg-6">
              <div class="input-group">
                <span class="input-group-btn">
                  <button class="btn btn-default" type="button">Go!</button>
                </span>
                <input type="text" class="form-control">
              </div>
            </div>
            <div class="col-lg-6">
              <div class="input-group">
                <input type="text" class="form-control">
                <span class="input-group-btn">
                  <button class="btn btn-default" type="button">Go!</button>
                </span>
              </div>
            </div>
          </div>
          
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
                </div>
                <input type="text" class="form-control">
              </div>
            </div>
            
            <div class="col-lg-6">
              <div class="input-group">
                <input type="text" class="form-control">
                <div class="input-group-btn">
                  <button type="button" class="btn btn-default dropdown-toggle"
                  data-toggle="dropdown" aria-expanded="false">Action <span class="caret"></span>
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
            </div>
          </div>
          
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
              </div>
            </div>
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
              </div>
            </div>
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
        <br>
        <br>
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
                  <img alt="Brand" height="20" src="../css/g.png">
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
          <br>配合navbar-link可弄出文字型的link非選單型的link，(原理是實作了hover等假類別的樣式)
          <br>.navbar-left 或 .navbar-right用來排版，我認為用right就好，left不要用
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
                <p class="navbar-text navbar-right">用p(text)和靠右弄出<a href="#" class="navbar-link">(登出連結)</a></p>
                
              </div>
            </div>
          </nav>
          <hr>
          <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
            <!-- We use the fluid option here to avoid overriding the fixed width of a normal container within the narrow content columns. -->
            <div class="container-fluid">
              <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-6">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Brand</a>
              </div>
              <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-6">
                <ul class="nav navbar-nav">
                  <li class="active"><a href="#">Home</a></li>
                  <li><a href="#">navbar-fixed-top{position: fixed;right: 0;left: 0;z-index: 1030;}</a></li>
                  <li><a href="#">讓選單列可以固定放在最上面，預設巡覽列的高度是 50px，可用body { padding-top: 70px; }</a></li>
                </ul>
              </div>
            </div>
          </nav>
          
          <nav class="navbar navbar-default navbar-fixed-bottom" role="navigation">
            <!-- We use the fluid option here to avoid overriding the fixed width of a normal container within the narrow content columns. -->
            <div class="container-fluid">
              <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-7">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Brand</a>
              </div>
              <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-7">
                <ul class="nav navbar-nav">
                  <li class="active"><a href="#">Home</a></li>
                  <li><a href="#">navbar-fixed-bottom{position: fixed;right: 0;left: 0;z-index: 1030;}</a></li>
                  <li><a href="#">固定在底部，body的css部分參考頂部的說明</a></li>
                </ul>
              </div>
            </div>
          </nav>
          <hr>
          navbar-static-top，設了一些nav不重要的格式(ex:border)，感覺是把靜態佈局的nav放在最上面可以加上這個class
          <nav class="navbar navbar-default navbar-static-top" role="navigation">
            <!-- We use the fluid option here to avoid overriding the fixed width of a normal container within the narrow content columns. -->
            <div class="container-fluid">
              <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-8">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Brand</a>
              </div>
              <!-- Collect the nav links, forms, and other content for toggling -->
              <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-8">
                <ul class="nav navbar-nav">
                  <li class="active"><a href="#">Home</a></li>
                  <li><a href="#">navbar-static-top</a></li>
                  <li><a href="#">Link</a></li>
                </ul>
              </div>
            </div>
          </nav>
          <hr>
          navbar-inverse 白底黑字變成黑底白字
          <nav class="navbar navbar-inverse" role="navigation">
            <div class="container-fluid">
              <!-- Brand and toggle get grouped for better mobile display -->
              <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-9">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="https://kkbruce.tw/bs3/Components#">Brand</a>
              </div>
              <!-- Collect the nav links, forms, and other content for toggling -->
              <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-9">
                <ul class="nav navbar-nav">
                  <li class="active"><a href="https://kkbruce.tw/bs3/Components#">Home</a></li>
                  <li><a href="https://kkbruce.tw/bs3/Components#">Link</a></li>
                  <li><a href="https://kkbruce.tw/bs3/Components#">Link</a></li>
                </ul>
              </div>
            </div>
          </nav>
          
          <hr>
          這個例子有點太難，晚點再來看
          <br>navbar-header，放一個商標和放一個小於768顯示的按鈕來show下拉選單
          <br>navbar-toggle collapsed是指折疊區塊
          <br>折疊區塊的第1個區塊放ul，內有2個link，和1個dropdown的link
          <br>第2區塊為form，不知道navbar-left有放有沒有差，裡面就是textbox和submit button
          <br>第3區塊類似第1區塊，只是有navbar-right靠右
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
              </div>
            </div>
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
            <p><b>麵包屑，原理是用ol和li來實作，分隔是用字型的圖形檔?，實作如下</b></p>
            <p><b>.breadcrumb>li+li:before {padding: 0 5px;color: #ccc;content: "/\00a0";}</b</b></p>
          </div>
          
          <ol class="breadcrumb">
            <li class="active">Home</li>
          </ol>
          <ol class="breadcrumb">
            <li><a href="https://kkbruce.tw/bs3/Components#">Home</a></li>
            <li class="active">Library</li>
          </ol>
          <ol class="breadcrumb" style="margin-bottom: 5px;">
            <li><a href="https://kkbruce.tw/bs3/Components#">Home</a></li>
            <li><a href="https://kkbruce.tw/bs3/Components#">Library</a></li>
            <li class="active">Data</li>
          </ol>
          
        </div>
        <br>
        
        
        
        <div class="container-fluid 單線邊框 橘色邊框">
          <div class="alert alert-success" role="alert">
            <p><b>有沒有nav看起來差不多，所以就用沒nav來展示範例了</b></p>
          </div>
          有nav的實作
          <nav>
            <ul class="pagination">
              <li><a href="#"><span aria-hidden="true">&laquo;</span><span class="sr-only">Previous</span></a></li>
              <li><a href="#">1</a></li>
              <li><a href="#">2</a></li>
              <li><a href="#">3</a></li>
              <li><a href="#">4</a></li>
              <li><a href="#">5</a></li>
              <li><a href="#"><span aria-hidden="true">&raquo;</span><span class="sr-only">Next</span></a></li>
            </ul>
          </nav>
          沒有nav的實作<br>
          <ul class="pagination">
            <li><a href="#"><span aria-hidden="true">&laquo;</span><span class="sr-only">Previous</span></a></li>
            <li><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li><a href="#"><span aria-hidden="true">&raquo;</span><span class="sr-only">Next</span></a></li>
          </ul>
          展示disabled和active 2種樣式，但是這兩種class不影嚮click的事件<br>
          放span就不會有click事件，但是«後面的sr-only span會多出一欄，先拿掉，也許用label就可以了，有空再試
          <ul class="pagination">
            <li class="disabled"><span aria-hidden="true">«(用span實作，不會有click事件</span></li>
            <li class="disabled"><a href="#"><span aria-hidden="true">«</span><span class="sr-only">Previous</span></a></li>
            <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
            <li class="active"><span>1(用span實作，不會有click事件) <span class="sr-only">(current)</span></span></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li><a href="#"><span aria-hidden="true">»</span><span class="sr-only">Next</span></a></li>
          </ul>
          
          <br>大型的pagination pagination-lg，中型，小型的pagination pagination-sm<br>
          <ul class="pagination pagination-lg">
            <li><a href="#"><span aria-hidden="true">«</span><span class="sr-only">Previous</span></a></li>
            <li><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#"><span aria-hidden="true">»</span><span class="sr-only">Next</span></a></li>
          </ul>
          <ul class="pagination">
            <li><a href="#"><span aria-hidden="true">«</span><span class="sr-only">Previous</span></a></li>
            <li><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#"><span aria-hidden="true">»</span><span class="sr-only">Next</span></a></li>
          </ul>
          <ul class="pagination pagination-sm">
            <li><a href="#"><span aria-hidden="true">«</span><span class="sr-only">Previous</span></a></li>
            <li><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#"><span aria-hidden="true">»</span><span class="sr-only">Next</span></a></li>
          </ul>
          <br>
          更換成pager樣式，我覺得這個比較好看，自動置中，適合簡單的樣式只有上一頁和下一頁沒有中間選單的
          <ul class="pager">
            <li><a href="#">Previous</a></li>
            <li><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">Next</a></li>
          </ul>
          <br>在li加入preious和next樣式來靠左和靠右，disabled一樣只有樣式不影嚮click<br>
          <ul class="pager">
            <li class="previous disabled"><a href="#"><span aria-hidden="true">&larr;</span> Older</a></li>
            <li class="next"><a href="#">Newer <span aria-hidden="true">&rarr;</span></a></li>
          </ul>
          
          
          
        </div>
        
      </html>
      
      </textarea>
      <br>
      <!-- ******************************************************************************************** -->
      <button type="button" onclick="javascriptWindow(document.getElementById('id7').value );">測試7</button>
      <br>
      <textarea id="id7" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
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
            <p><b>標籤</b></p>
          </div>
          展示h1-h6的樣式label label-default(span tag)
          <h1>Example heading <span class="label label-default">New</span></h1>
          <h2>Example heading <span class="label label-default">New</span></h2>
          <h3>Example heading <span class="label label-default">New</span></h3>
          <h4>Example heading <span class="label label-default">New</span></h4>
          <h5>Example heading <span class="label label-default">New</span></h5>
          <h6>Example heading <span class="label label-default">New</span></h6>
          展示(span tag)label-default、 label-primary、label-success、label-info、label-warning、label-danger
          <br>
          <span class="label label-default">Default</span>
          <span class="label label-primary">Primary</span>
          <span class="label label-success">Success</span>
          <span class="label label-info">Info</span>
          <span class="label label-warning">Warning</span>
          <span class="label label-danger">Danger</span>
          <br>
          氣泡樣式badge，用來提示數量等額外訊息，透過 CSS 的 :empty 選擇器無資料會自動隱藏，ie8不支援
          <br>
          <a href="#">Inbox <span class="badge">42</span></a>
          <button class="btn btn-primary" type="button">
          Messages <span class="badge">4</span>
          </button>
          <br>
          列後來個應用的範例
          <ul class="nav nav-pills" role="tablist">
            <li role="presentation" class="active"><a href="#">Home <span class="badge">42</span></a></li>
            <li role="presentation"><a href="#">Profile</a></li>
            <li role="presentation"><a href="#">Messages <span class="badge">3</span></a></li>
          </ul>
          
        </div>
        <br>
        
        <div class="container-fluid 單線邊框 橘色邊框">
          <div class="alert alert-success" role="alert">
            <p><b>大螢幕，只要在最外層的容器加入div包起來，class設成jumbotron，而子div通常有個container類別？</b></p>
            <p><b>To make the jumbotron full width, and without rounded corners, place it outside all .containers and instead add a .container within.</b></p>
          </div>
        </div>
        <br>
        jumbotron類別設置為大螢幕的展示方式，應該是指投影之類的，底層應該只是調了字型大小、邊距之類的
        <div class="jumbotron">
          <h1>Hello, world!測試組</h1>
          <p>This is a simple hero unit, a simple jumbotron-style component for calling extra attention to featured content or information.</p>
          <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a></p>
        </div>
        <div >
          <h1>Hello, world!對照組</h1>
          <p>This is a simple hero unit, a simple jumbotron-style component for calling extra attention to featured content or information.</p>
          <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a></p>
        </div>
        page-header類別，用來設定標題，乍看之下只是多了下面一條border 的線而已
        <div class="page-header">
          <h1>測試組Example page header <small>Subtext for header</small></h1>
          h1之外的文字
        </div>
        <div >
          <h1>對照組Example page header <small>Subtext for header</small></h1>
          h1之外的文字
        </div>
        <br>
        <br>
      </html>
      
      
      
      </textarea>
      <br>
      <!-- ******************************************************************************************** -->
      <button type="button" onclick="javascriptWindow(document.getElementById('id8').value );">測試8</button>
      <br>
      <textarea id="id8" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
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
            <p><b>縮圖佈局</b></p>
          </div>
          
          用row定義md佔3欄，xs佔6欄，a的class thumbnail會設border為藍色，padd 4px、backgruond等等
          <br>因為第一個圖和後面的圖大小不一樣，所以加上visible-**-block和clearfix
          <div class="row">
            <div class="col-xs-6 col-md-3">
              <a href="#" class="thumbnail">
                <img data-src="holder.js/100%x180" alt="100%x180" src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iMTcyIiBoZWlnaHQ9IjE4MCIgdmlld0JveD0iMCAwIDE3MiAxODAiIHByZXNlcnZlQXNwZWN0UmF0aW89Im5vbmUiPjxkZWZzLz48cmVjdCB3aWR0aD0iMTcyIiBoZWlnaHQ9IjE4MCIgZmlsbD0iI0VFRUVFRSIvPjxnPjx0ZXh0IHg9IjU5Ljk3NjU2MjUiIHk9IjkwIiBzdHlsZT0iZmlsbDojQUFBQUFBO2ZvbnQtd2VpZ2h0OmJvbGQ7Zm9udC1mYW1pbHk6QXJpYWwsIEhlbHZldGljYSwgT3BlbiBTYW5zLCBzYW5zLXNlcmlmLCBtb25vc3BhY2U7Zm9udC1zaXplOjEwcHQ7ZG9taW5hbnQtYmFzZWxpbmU6Y2VudHJhbCI+MTcyeDE4MDwvdGV4dD48L2c+PC9zdmc+" data-holder-rendered="true" style="height: 180px; width: 100%; display: block;">
                寫一些文對照一下
              </a>
            </div>
            <div class="col-xs-6 col-md-3">
              <a href="#" class="thumbnail">
                <img data-src="holder.js/100%x180" alt="100%x180" src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iMTcyIiBoZWlnaHQ9IjE4MCIgdmlld0JveD0iMCAwIDE3MiAxODAiIHByZXNlcnZlQXNwZWN0UmF0aW89Im5vbmUiPjxkZWZzLz48cmVjdCB3aWR0aD0iMTcyIiBoZWlnaHQ9IjE4MCIgZmlsbD0iI0VFRUVFRSIvPjxnPjx0ZXh0IHg9IjU5Ljk3NjU2MjUiIHk9IjkwIiBzdHlsZT0iZmlsbDojQUFBQUFBO2ZvbnQtd2VpZ2h0OmJvbGQ7Zm9udC1mYW1pbHk6QXJpYWwsIEhlbHZldGljYSwgT3BlbiBTYW5zLCBzYW5zLXNlcmlmLCBtb25vc3BhY2U7Zm9udC1zaXplOjEwcHQ7ZG9taW5hbnQtYmFzZWxpbmU6Y2VudHJhbCI+MTcyeDE4MDwvdGV4dD48L2c+PC9zdmc+" data-holder-rendered="true" style="height: 180px; width: 100%; display: block;">
              </a>
            </div>
            <div class="visible-sm-block  visible-xs-block  clearfix"></div>
            <div class="col-xs-6 col-md-3">
              <a href="#" class="thumbnail">
                <img data-src="holder.js/100%x180" alt="100%x180" src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iMTcyIiBoZWlnaHQ9IjE4MCIgdmlld0JveD0iMCAwIDE3MiAxODAiIHByZXNlcnZlQXNwZWN0UmF0aW89Im5vbmUiPjxkZWZzLz48cmVjdCB3aWR0aD0iMTcyIiBoZWlnaHQ9IjE4MCIgZmlsbD0iI0VFRUVFRSIvPjxnPjx0ZXh0IHg9IjU5Ljk3NjU2MjUiIHk9IjkwIiBzdHlsZT0iZmlsbDojQUFBQUFBO2ZvbnQtd2VpZ2h0OmJvbGQ7Zm9udC1mYW1pbHk6QXJpYWwsIEhlbHZldGljYSwgT3BlbiBTYW5zLCBzYW5zLXNlcmlmLCBtb25vc3BhY2U7Zm9udC1zaXplOjEwcHQ7ZG9taW5hbnQtYmFzZWxpbmU6Y2VudHJhbCI+MTcyeDE4MDwvdGV4dD48L2c+PC9zdmc+" data-holder-rendered="true" style="height: 180px; width: 100%; display: block;">
              </a>
            </div>
            <div class="col-xs-6 col-md-3">
              <a href="#" class="thumbnail">
                <img data-src="holder.js/100%x180" alt="100%x180" src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iMTcyIiBoZWlnaHQ9IjE4MCIgdmlld0JveD0iMCAwIDE3MiAxODAiIHByZXNlcnZlQXNwZWN0UmF0aW89Im5vbmUiPjxkZWZzLz48cmVjdCB3aWR0aD0iMTcyIiBoZWlnaHQ9IjE4MCIgZmlsbD0iI0VFRUVFRSIvPjxnPjx0ZXh0IHg9IjU5Ljk3NjU2MjUiIHk9IjkwIiBzdHlsZT0iZmlsbDojQUFBQUFBO2ZvbnQtd2VpZ2h0OmJvbGQ7Zm9udC1mYW1pbHk6QXJpYWwsIEhlbHZldGljYSwgT3BlbiBTYW5zLCBzYW5zLXNlcmlmLCBtb25vc3BhY2U7Zm9udC1zaXplOjEwcHQ7ZG9taW5hbnQtYmFzZWxpbmU6Y2VudHJhbCI+MTcyeDE4MDwvdGV4dD48L2c+PC9zdmc+" data-holder-rendered="true" style="height: 180px; width: 100%; display: block;">
              </a>
            </div>
          </div>
          <br>
          用row定義md佔3欄，xs佔6欄，和上面差不多，但是a的class thumbnail改成div的class thumbnail
          <br>div中加入class=caption的div，caption的div內文就可以自已亂填了
          <div class="row">
            <div class="col-sm-6 col-md-4">
              <div class="thumbnail">
                <img data-src="holder.js/100%x200" alt="100%x200" src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iMjQzIiBoZWlnaHQ9IjIwMCIgdmlld0JveD0iMCAwIDI0MyAyMDAiIHByZXNlcnZlQXNwZWN0UmF0aW89Im5vbmUiPjxkZWZzLz48cmVjdCB3aWR0aD0iMjQzIiBoZWlnaHQ9IjIwMCIgZmlsbD0iI0VFRUVFRSIvPjxnPjx0ZXh0IHg9IjkyLjk2MDkzNzUiIHk9IjEwMCIgc3R5bGU9ImZpbGw6I0FBQUFBQTtmb250LXdlaWdodDpib2xkO2ZvbnQtZmFtaWx5OkFyaWFsLCBIZWx2ZXRpY2EsIE9wZW4gU2Fucywgc2Fucy1zZXJpZiwgbW9ub3NwYWNlO2ZvbnQtc2l6ZToxMXB0O2RvbWluYW50LWJhc2VsaW5lOmNlbnRyYWwiPjI0M3gyMDA8L3RleHQ+PC9nPjwvc3ZnPg==" data-holder-rendered="true" style="height: 200px; width: 100%; display: block;">
                <div class="caption">
                  <h3>Thumbnail label</h3>
                  <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                  <p><a href="https://kkbruce.tw/bs3/Components#" class="btn btn-primary" role="button">Button</a> <a href="https://kkbruce.tw/bs3/Components#" class="btn btn-default" role="button">Button</a></p>
                </div>
              </div>
            </div>
            <div class="col-sm-6 col-md-4">
              <div class="thumbnail">
                <img data-src="holder.js/100%x200" alt="100%x200" src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iMjQzIiBoZWlnaHQ9IjIwMCIgdmlld0JveD0iMCAwIDI0MyAyMDAiIHByZXNlcnZlQXNwZWN0UmF0aW89Im5vbmUiPjxkZWZzLz48cmVjdCB3aWR0aD0iMjQzIiBoZWlnaHQ9IjIwMCIgZmlsbD0iI0VFRUVFRSIvPjxnPjx0ZXh0IHg9IjkyLjk2MDkzNzUiIHk9IjEwMCIgc3R5bGU9ImZpbGw6I0FBQUFBQTtmb250LXdlaWdodDpib2xkO2ZvbnQtZmFtaWx5OkFyaWFsLCBIZWx2ZXRpY2EsIE9wZW4gU2Fucywgc2Fucy1zZXJpZiwgbW9ub3NwYWNlO2ZvbnQtc2l6ZToxMXB0O2RvbWluYW50LWJhc2VsaW5lOmNlbnRyYWwiPjI0M3gyMDA8L3RleHQ+PC9nPjwvc3ZnPg==" data-holder-rendered="true" style="height: 200px; width: 100%; display: block;">
                <div class="caption">
                  <h3>Thumbnail label</h3>
                  <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                  <p><a href="https://kkbruce.tw/bs3/Components#" class="btn btn-primary" role="button">Button</a> <a href="https://kkbruce.tw/bs3/Components#" class="btn btn-default" role="button">Button</a></p>
                </div>
              </div>
            </div>
            <div class="col-sm-6 col-md-4">
              <div class="thumbnail">
                <img data-src="holder.js/100%x200" alt="100%x200" src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iMjQzIiBoZWlnaHQ9IjIwMCIgdmlld0JveD0iMCAwIDI0MyAyMDAiIHByZXNlcnZlQXNwZWN0UmF0aW89Im5vbmUiPjxkZWZzLz48cmVjdCB3aWR0aD0iMjQzIiBoZWlnaHQ9IjIwMCIgZmlsbD0iI0VFRUVFRSIvPjxnPjx0ZXh0IHg9IjkyLjk2MDkzNzUiIHk9IjEwMCIgc3R5bGU9ImZpbGw6I0FBQUFBQTtmb250LXdlaWdodDpib2xkO2ZvbnQtZmFtaWx5OkFyaWFsLCBIZWx2ZXRpY2EsIE9wZW4gU2Fucywgc2Fucy1zZXJpZiwgbW9ub3NwYWNlO2ZvbnQtc2l6ZToxMXB0O2RvbWluYW50LWJhc2VsaW5lOmNlbnRyYWwiPjI0M3gyMDA8L3RleHQ+PC9nPjwvc3ZnPg==" data-holder-rendered="true" style="height: 200px; width: 100%; display: block;">
                <div class="caption">
                  <h3>Thumbnail label</h3>
                  <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                  <p><a href="https://kkbruce.tw/bs3/Components#" class="btn btn-primary" role="button">Button</a> <a href="https://kkbruce.tw/bs3/Components#" class="btn btn-default" role="button">Button</a></p>
                </div>
              </div>
            </div>
          </div>
        </div>
        <br>
      </html>
      </textarea>
      <br>
      <!-- ******************************************************************************************** -->
      <button type="button" onclick="javascriptWindow(document.getElementById('id9').value );">測試9</button>
      <br>
      <textarea id="id9" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
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
            <p><b>警告的樣式</b></p>
          </div>
          警告 alert-success
          <div class="alert alert-success" role="alert">
            <strong>做得好！<!--Well done!--></strong> 你成功的讀取這一條重要的警告訊息。<!--You successfully read this important alert message.-->
          </div>
          警告 alert-info
          <div class="alert alert-info" role="alert">
            <strong>注意！<!--Heads up!--></strong> 這訊息提醒你需要注意，但它不是那麼重要。<!--This alert needs your attention, but it's not super important.-->
          </div>
          警告 alert-warning
          <div class="alert alert-warning" role="alert">
            <strong>警告！<!--Warning!--></strong> 檢查一下你自己，你看起來不是很好。<!--Better check yourself, you're not looking too good.-->
          </div>
          警告 alert-danger
          <div class="alert alert-danger" role="alert">
            <strong>媽呀！<!--Oh snap!--></strong> 做幾個改變並嘗試重新送出。<!--Change a few things up and try submitting again.-->
          </div>
          <hr>
          可關閉的警告，加上 alert-dismissible 類別之外，還要加上一個close的按鈕，當範本寫入即可
          <div class="alert alert-success 加上 alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
            <strong>做得好！<!--Well done!--></strong> 你成功的讀取這一條重要的警告訊息。<!--You successfully read this important alert message.-->
          </div>
          <hr>
          強調link 用class="alert-link"，字體會變粗，詳細懶得看
          <div class="alert alert-success" role="alert">
            <strong>Well done!</strong> You successfully read <a href="https://kkbruce.tw/bs3/Components#" class="alert-link">this important alert message</a>.
          </div>
          <div class="alert alert-info" role="alert">
            <strong>Heads up!</strong> This <a href="https://kkbruce.tw/bs3/Components#" class="alert-link">alert needs your attention</a>, but it's not super important.
          </div>
          <div class="alert alert-warning" role="alert">
            <strong>Warning!</strong> Better check yourself, you're <a href="https://kkbruce.tw/bs3/Components#" class="alert-link">not looking too good</a>.
          </div>
          <div class="alert alert-danger" role="alert">
            <strong>Oh snap!</strong> <a href="https://kkbruce.tw/bs3/Components#" class="alert-link">Change a few things up</a> and try submitting again.
          </div>
          <hr>
          
          
        </div>
        <br>
        <div class="container-fluid 單線邊框 橘色邊框">
          <div class="alert alert-success" role="alert">
            <p><b>進度條使用了 CSS3 的 transition 和 animation 屬性來實現一些特效。這些功能在 Internet Explorer 9 之前或舊版 Firefox 並不支援。Opera 12 不支援 animation 屬性。</b></p>
          </div>
          進度條的範例，外層用div class="progress"，用來畫外框，原理是用div佔位後，再畫background
          <br>進度條在內層div class=progress-bar，原理是用div佔位，配合css的width畫出來
          <br>其它那些有的沒的屬性好像沒用，大概是給閱讀器看的
          <div class="progress">
            <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
              <span class="sr-only">60% Complete</span>
            </div>
          </div>
          為進度條加上進行百分比，只要在內層的div加上text即可，建議加上 min-width 屬性以確保所有標籤文字能完全顯示出來。
          <div class="progress">
      <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
        60%
      </div>
    </div>
    <hr>
    展示內層進度條的顏色 progress-bar-success
    <div class="progress">
      <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
        <span class="sr-only">40% Complete (success)</span>progress-bar-success
      </div>
    </div>
    展示內層進度條的顏色 progress-bar-info
    <div class="progress">
      <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
        <span class="sr-only">20% Complete</span>progress-bar-info
      </div>
    </div>
    展示內層進度條的顏色 progress-bar-warning
    <div class="progress">
      <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
        <span class="sr-only">60% Complete (warning)</span>progress-bar-warning
      </div>
    </div>
    展示內層進度條的顏色 progress-bar-danger
    <div class="progress">
      <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
        <span class="sr-only">80% Complete (danger)</span>progress-bar-danger
      </div>
    </div>
    <hr>
    使用 CSS3 的 gradient 屬性建立條紋效果。不支援 IE8。progress-bar-striped
    <br>將 .active 加入 .progress-bar-striped 類別，以呈現由右向左的條紋動畫效果。IE9 之前並不支援。
    <br>.activ 加入到其中2個看效果
    <div class="progress">
      <div class="progress-bar progress-bar-success progress-bar-striped active" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
        <span class="sr-only">40% Complete (success)</span>progress-bar-success progress-bar-striped active
      </div>
    </div>
    <div class="progress">
      <div class="progress-bar progress-bar-info progress-bar-striped" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
        <span class="sr-only">20% Complete</span>progress-bar-info progress-bar-striped
      </div>
    </div>
    <div class="progress">
      <div class="progress-bar progress-bar-warning progress-bar-striped" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
        <span class="sr-only">60% Complete (warning)</span> progress-bar-warning progress-bar-striped
      </div>
    </div>
    <div class="progress">
      <div class="progress-bar progress-bar-danger progress-bar-striped active" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
        <span class="sr-only">80% Complete (danger)</span>progress-bar-danger progress-bar-striped active
      </div>
    </div>
    <hr>
    可以有多個內層的div progress-bar，產生區塊變色的效果
<div class="progress">
      <div class="progress-bar progress-bar-success" style="width: 35%">
        <span class="sr-only">35% Complete (success)</span>
      </div>
      <div class="progress-bar progress-bar-warning progress-bar-striped" style="width: 20%">
        <span class="sr-only">20% Complete (warning)</span>
      </div>
      <div class="progress-bar progress-bar-danger" style="width: 10%">
        <span class="sr-only">10% Complete (danger)</span>
      </div>
    </div>    
    
          
        </div>
        
        
      </html>
      </textarea>
      <br>
      <!-- ******************************************************************************************** -->
      <button type="button" onclick="javascriptWindow(document.getElementById('id10').value );">測試10</button>
      <br>
      <textarea id="id10" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
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
            <p><b>媒體物件，簡單來說就是一種佈局樣式</b></p>
          </div>
          
    外層div用media {margin-top: 15px;}<br>
    <br>內層左側用a.media-left ，設table排版和右邊內縮{padding-right: 10px;}{display: table-cell;vertical-align: top;}
    <br>內層主體用div.media-body，設table排版{display: table-cell;vertical-align: top;}
    <br>內層主體div.media-body h4.media-heading，設邊距而已 {margin-top: 0;margin-bottom: 5px;}
    <div class="media">
      <a class="media-left" href="https://kkbruce.tw/bs3/Components#">
        <img data-src="holder.js/64x64" alt="64x64" src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iNjQiIGhlaWdodD0iNjQiIHZpZXdCb3g9IjAgMCA2NCA2NCIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+PGRlZnMvPjxyZWN0IHdpZHRoPSI2NCIgaGVpZ2h0PSI2NCIgZmlsbD0iI0VFRUVFRSIvPjxnPjx0ZXh0IHg9IjEzLjM4MjgxMjUiIHk9IjMyIiBzdHlsZT0iZmlsbDojQUFBQUFBO2ZvbnQtd2VpZ2h0OmJvbGQ7Zm9udC1mYW1pbHk6QXJpYWwsIEhlbHZldGljYSwgT3BlbiBTYW5zLCBzYW5zLXNlcmlmLCBtb25vc3BhY2U7Zm9udC1zaXplOjEwcHQ7ZG9taW5hbnQtYmFzZWxpbmU6Y2VudHJhbCI+NjR4NjQ8L3RleHQ+PC9nPjwvc3ZnPg==" data-holder-rendered="true" style="width: 64px; height: 64px;">
      </a>
      <div class="media-body">
        <h4 class="media-heading">Media heading</h4>
        Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
      </div>
    </div>
    
	同上例，只是media的body中又加了一個media
    <div class="media">
      <a class="media-left" href="https://kkbruce.tw/bs3/Components#">
        <img data-src="holder.js/64x64" alt="64x64" src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iNjQiIGhlaWdodD0iNjQiIHZpZXdCb3g9IjAgMCA2NCA2NCIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+PGRlZnMvPjxyZWN0IHdpZHRoPSI2NCIgaGVpZ2h0PSI2NCIgZmlsbD0iI0VFRUVFRSIvPjxnPjx0ZXh0IHg9IjEzLjM4MjgxMjUiIHk9IjMyIiBzdHlsZT0iZmlsbDojQUFBQUFBO2ZvbnQtd2VpZ2h0OmJvbGQ7Zm9udC1mYW1pbHk6QXJpYWwsIEhlbHZldGljYSwgT3BlbiBTYW5zLCBzYW5zLXNlcmlmLCBtb25vc3BhY2U7Zm9udC1zaXplOjEwcHQ7ZG9taW5hbnQtYmFzZWxpbmU6Y2VudHJhbCI+NjR4NjQ8L3RleHQ+PC9nPjwvc3ZnPg==" data-holder-rendered="true" style="width: 64px; height: 64px;">
      </a>
      <div class="media-body">
        <h4 class="media-heading">Media heading</h4>
        Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
        <div class="media">
          <a class="media-left" href="https://kkbruce.tw/bs3/Components#">
            <img data-src="holder.js/64x64" alt="64x64" src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iNjQiIGhlaWdodD0iNjQiIHZpZXdCb3g9IjAgMCA2NCA2NCIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+PGRlZnMvPjxyZWN0IHdpZHRoPSI2NCIgaGVpZ2h0PSI2NCIgZmlsbD0iI0VFRUVFRSIvPjxnPjx0ZXh0IHg9IjEzLjM4MjgxMjUiIHk9IjMyIiBzdHlsZT0iZmlsbDojQUFBQUFBO2ZvbnQtd2VpZ2h0OmJvbGQ7Zm9udC1mYW1pbHk6QXJpYWwsIEhlbHZldGljYSwgT3BlbiBTYW5zLCBzYW5zLXNlcmlmLCBtb25vc3BhY2U7Zm9udC1zaXplOjEwcHQ7ZG9taW5hbnQtYmFzZWxpbmU6Y2VudHJhbCI+NjR4NjQ8L3RleHQ+PC9nPjwvc3ZnPg==" data-holder-rendered="true" style="width: 64px; height: 64px;">
          </a>
          <div class="media-body">
            <h4 class="media-heading">Nested media heading</h4>
            Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
          </div>
        </div>
      </div>
    </div>
    此列是在展示div.media div.media-body後面放a.media-right的例子，這個css只是設一下版面和table排版而已
    <div class="media">
      <div class="media-body">
        <h4 class="media-heading">Media heading</h4>
        Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis.
      </div>
      <a class="media-right" href="https://kkbruce.tw/bs3/Components#">
        <img data-src="holder.js/64x64" alt="64x64" src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iNjQiIGhlaWdodD0iNjQiIHZpZXdCb3g9IjAgMCA2NCA2NCIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+PGRlZnMvPjxyZWN0IHdpZHRoPSI2NCIgaGVpZ2h0PSI2NCIgZmlsbD0iI0VFRUVFRSIvPjxnPjx0ZXh0IHg9IjEzLjM4MjgxMjUiIHk9IjMyIiBzdHlsZT0iZmlsbDojQUFBQUFBO2ZvbnQtd2VpZ2h0OmJvbGQ7Zm9udC1mYW1pbHk6QXJpYWwsIEhlbHZldGljYSwgT3BlbiBTYW5zLCBzYW5zLXNlcmlmLCBtb25vc3BhY2U7Zm9udC1zaXplOjEwcHQ7ZG9taW5hbnQtYmFzZWxpbmU6Y2VudHJhbCI+NjR4NjQ8L3RleHQ+PC9nPjwvc3ZnPg==" data-holder-rendered="true" style="width: 64px; height: 64px;">
      </a>
    </div>
    <div class="media">
      <a class="media-left" href="https://kkbruce.tw/bs3/Components#">
        <img data-src="holder.js/64x64" alt="64x64" src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iNjQiIGhlaWdodD0iNjQiIHZpZXdCb3g9IjAgMCA2NCA2NCIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+PGRlZnMvPjxyZWN0IHdpZHRoPSI2NCIgaGVpZ2h0PSI2NCIgZmlsbD0iI0VFRUVFRSIvPjxnPjx0ZXh0IHg9IjEzLjM4MjgxMjUiIHk9IjMyIiBzdHlsZT0iZmlsbDojQUFBQUFBO2ZvbnQtd2VpZ2h0OmJvbGQ7Zm9udC1mYW1pbHk6QXJpYWwsIEhlbHZldGljYSwgT3BlbiBTYW5zLCBzYW5zLXNlcmlmLCBtb25vc3BhY2U7Zm9udC1zaXplOjEwcHQ7ZG9taW5hbnQtYmFzZWxpbmU6Y2VudHJhbCI+NjR4NjQ8L3RleHQ+PC9nPjwvc3ZnPg==" data-holder-rendered="true" style="width: 64px; height: 64px;">
      </a>
      <div class="media-body">
        <h4 class="media-heading">Media heading</h4>
        Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis.
      </div>
      <a class="media-right" href="https://kkbruce.tw/bs3/Components#">
        <img data-src="holder.js/64x64" alt="64x64" src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iNjQiIGhlaWdodD0iNjQiIHZpZXdCb3g9IjAgMCA2NCA2NCIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+PGRlZnMvPjxyZWN0IHdpZHRoPSI2NCIgaGVpZ2h0PSI2NCIgZmlsbD0iI0VFRUVFRSIvPjxnPjx0ZXh0IHg9IjEzLjM4MjgxMjUiIHk9IjMyIiBzdHlsZT0iZmlsbDojQUFBQUFBO2ZvbnQtd2VpZ2h0OmJvbGQ7Zm9udC1mYW1pbHk6QXJpYWwsIEhlbHZldGljYSwgT3BlbiBTYW5zLCBzYW5zLXNlcmlmLCBtb25vc3BhY2U7Zm9udC1zaXplOjEwcHQ7ZG9taW5hbnQtYmFzZWxpbmU6Y2VudHJhbCI+NjR4NjQ8L3RleHQ+PC9nPjwvc3ZnPg==" data-holder-rendered="true" style="width: 64px; height: 64px;">
      </a>
    </div>
          
          
          
        </div>
        <br>
        
        
      </html>
      
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
      <!-- ******************************************************************************************** -->
      <button type="button" onclick="javascriptWindow(document.getElementById('id12').value );">測試12</button>
      <br>
      <textarea id="id12" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
      spellcheck="false">
      <script>
      
      </script>
      </textarea>
      <br>
                  <!-- ******************************************************************************************** -->
      <button type="button" onclick="javascriptWindow(document.getElementById('id13').value );">測試13</button>
      <br>
      <textarea id="id13" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
      spellcheck="false">
      <script>
      
      </script>
      </textarea>
      <br>
      <!-- ******************************************************************************************** -->
      <button type="button" onclick="javascriptWindow(document.getElementById('id14').value );">測試14</button>
      <br>
      <textarea id="id14" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
      spellcheck="false">
      <script>
      
      </script>
      </textarea>
      <br>
      <!-- ******************************************************************************************** -->
      <button type="button" onclick="javascriptWindow(document.getElementById('id15').value );">測試15</button>
      <br>
      <textarea id="id15" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
      spellcheck="false">
      <script>
      
      </script>
      </textarea>
      <br>
      <!-- ******************************************************************************************** -->
      <button type="button" onclick="javascriptWindow(document.getElementById('id16').value );">測試16</button>
      <br>
      <textarea id="id16" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
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