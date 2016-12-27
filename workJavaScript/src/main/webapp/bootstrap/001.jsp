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
Bootstrap 所有 JavaScript 外掛都相依於 jQuery
目前 Bootstrap 3 為了相容性考量，支援 jQuery 1.9.1 之後的版本，請勿使用 jQuery 2.x
3.37好像有支援jquery3，以後再看看
Internet Explorer 8(6-8?) 需要使用 Respond.js才能支援Media Query
引入respond.min.js，但要在css的后面（越早引入越好，在ie下面看到页面闪屏的概率就越低，因为最初css会先渲染出来，如果respond.js加载得很后面，这时重新根据media query解析出来的css会再改变一次页面的布局等，所以看起来有闪屏的现象）
Bootstrap 3 不支援舊版本 IE 相容性模式。為了確保 IE 是使用最新的呈現模式，考慮將下列 <meta> 加入你的頁面：
meta http-equiv="X-UA-Compatible" content="IE=edge"＞
    </pre>
    <div id="div0" align="center">
      <p>
        <a href="#id1">格線grid</a>
      </p>
      <p>
        <a href="#id2">顯示和排版(文字排版、程式碼使用)</a>
      </p>
      <p>
        <a href="#id3">表格</a>
      </p>
      <p>
        <a href="#id4">表單</a>
      </p>
      <p>
        <a href="#id5">input項目</a>
      </p>
      <p>
        <a href="#id6">按鈕</a>
      </p>
      <p>
        <a href="#id7">圖片</a>
      </p>
      <p>
        <a href="#id8">顯示，輔助類主攻顏色變化，浮動顯示、輔助圖示</a>
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
        <div class="container 單線邊框">
          div容器container，.container 用於自適應且固定寬度的容器，不過應該很少會用到吧
          正常都是用100%
        </div>
        <br>
        <h3 id="grid-options">格線選項<!--Grid options--></h3>
        <p>
          請參考以下方便的表格，以瞭解 Bootstrap 3 的格線系統是如何橫跨多種設備運作。
          <!--See how aspects of the Bootstrap grid system work across multiple devices with a handy table.-->
        </p>
        <div class="table-responsive">
          <table class="table table-bordered table-striped">
            <thead>
              <tr>
                <th></th>
                <th>
                  超小螢幕設備
                  <small>手機（&lt;768px）</small>
                </th>
                <th>
                  小螢幕設備
                  <small>平板（≥768px）</small>
                </th>
                <th>
                  中螢幕設備
                  <small>桌面（≥992px）</small>
                </th>
                <th>
                  大螢幕設備
                  <small>大桌面（≥1200px）</small>
                </th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <th class="text-nowrap">格線行為<!--Grid behavior--></th>
                <td>總是水平怖局<!--Horizontal at all times--></td>
                <td colspan="3">開始是折疊的，當超過判斷點時回復水平怖局<!--Collapsed to start, horizontal above breakpoints--></td>
              </tr>
              <tr>
                <th class="text-nowrap">容器寬度<!--Container width--></th>
                <td>無（自動）<!--None (auto)--></td>
                <td>750px</td>
                <td>970px</td>
                <td>1170px</td>
              </tr>
              <tr>
                <th class="text-nowrap">類別前綴<!--Class prefix--></th>
                <td><code>.col-xs-</code></td>
                <td><code>.col-sm-</code></td>
                <td><code>.col-md-</code></td>
                <td><code>.col-lg-</code></td>
              </tr>
              <tr>
                <th class="text-nowrap">column 數<!--# of columns--></th>
                <td colspan="4">12</td>
              </tr>
              <tr>
                <th class="text-nowrap">column 寬度<!--Column width--></th>
                <td class="text-muted">自動<!--Auto--></td>
                <td>~62px</td>
                <td>~81px</td>
                <td>~97px</td>
              </tr>
              <tr>
                <th class="text-nowrap">中縫寬度<!--Gutter width--></th>
                <td colspan="4">30px（column 左右邊各 15px）<!--30px (15px on each side of a column)--></td>
              </tr>
              <tr>
                <th class="text-nowrap">可巢狀套用<!--Nestable--></th>
                <td colspan="4">是<!--Yes--></td>
              </tr>
              <tr>
                <th class="text-nowrap">位移（Offsets）</th>
                <td colspan="4">是<!--Yes--></td>
              </tr>
              <tr>
                <th class="text-nowrap">column 排序<!--Column ordering--></th>
                <td colspan="4">是<!--Yes--></td>
              </tr>
            </tbody>
          </table>
          <br>
          <div class="container-fluid 單線邊框 橘色邊框">
            <div class="alert alert-success" role="alert">
              <p> .container-fluid 用於 100% 寬度的容器，橫跨可視區域的全部寬度。
                <b>以下的例子是用md(992px-1200px)，所以小於992時，每個欄位都會變100%填滿
                而>992和>1200時，依然用12格來分開排列</b>
              </p>
            </div>
            <div class="row">
              <div class="col-md-1 單線邊框">.col-md-1</div>
              <div class="col-md-1 單線邊框">.col-md-1</div>
              <div class="col-md-1 單線邊框">.col-md-1</div>
              <div class="col-md-1 單線邊框">.col-md-1</div>
              <div class="col-md-1 單線邊框">.col-md-1</div>
              <div class="col-md-1 單線邊框">.col-md-1</div>
              <div class="col-md-1 單線邊框">.col-md-1</div>
              <div class="col-md-1 單線邊框">.col-md-1</div>
              <div class="col-md-1 單線邊框">.col-md-1</div>
              <div class="col-md-1 單線邊框">.col-md-1</div>
              <div class="col-md-1 單線邊框">.col-md-1</div>
              <div class="col-md-1 單線邊框">.col-md-1</div>
            </div>
            <div class="row">
              <div class="col-md-8 單線邊框">.col-md-8</div>
              <div class="col-md-4 單線邊框">.col-md-4</div>
            </div>
            <div class="row">
              <div class="col-md-4 單線邊框">.col-md-4</div>
              <div class="col-md-4 單線邊框">.col-md-4</div>
              <div class="col-md-4 單線邊框">.col-md-4</div>
            </div>
            <div class="row">
              <div class="col-md-6 單線邊框">.col-md-6</div>
              <div class="col-md-6 單線邊框">.col-md-6</div>
            </div>
          </div>
          <br>
          
          <div class="container-fluid 單線邊框 橘色邊框">          <div class="alert alert-success" role="alert">
            <p> .container-fluid 用於 100% 寬度的容器，橫跨可視區域的全部寬度。
              <b>此例的重點是沒有設ms，但是會吃xs的值，表示media query是用min-width來做的</b>
            </p>
          </div>
          <!-- 製作一個 100% 寬度和兩個 50% 寬度，在行動設備上堆疊的 column -->
          <div class="row">
            <div class="col-xs-12 col-md-8 單線邊框">.col-xs-12 .col-md-8</div>
            <div class="col-xs-6 col-md-4 單線邊框">.col-xs-6 .col-md-4</div>
          </div>
          <!-- 一開始，在行動設備上 column 會是 50% 寬度，提升至桌面大小後，寬度會平均為 33.3% -->
          <div class="row">
            <div class="col-xs-6 col-md-4 單線邊框">.col-xs-6 .col-md-4</div>
            <div class="col-xs-6 col-md-4 單線邊框">.col-xs-6 .col-md-4</div>
            <div class="col-xs-6 col-md-4 單線邊框">.col-xs-6 .col-md-4</div>
          </div>
          <!-- 在行動或桌面設備，column 寬度總是 50% 寬度 -->
          <div class="row">
            <div class="col-xs-6 單線邊框">.col-xs-6</div>
            <div class="col-xs-6 單線邊框">.col-xs-6</div>
          </div>
        </div>
        <br>
        <div class="container-fluid 單線邊框 橘色邊框">
          <div class="alert alert-success" role="alert">
            <p> .container-fluid 用於 100% 寬度的容器，橫跨可視區域的全部寬度。
              <b>此例要看的地方是，row一定會重新寫一行</b>
            </p>
          </div>
          <div class="row">
            <div class="col-xs-12 col-sm-6 col-md-8 單線邊框">.col-xs-12 .col-sm-6 .col-md-8</div>
            <div class="col-xs-6 col-md-4 單線邊框">.col-xs-6 .col-md-4</div>
          </div>
          <div class="row">
            <div class="col-xs-6 col-sm-4 單線邊框">.col-xs-6 .col-sm-4</div>
            <div class="col-xs-6 col-sm-4 單線邊框">.col-xs-6 .col-sm-4</div>
            <!-- 選項：如果他們內容有不符合的高度，清除 XS column -->
            <div class="clearfix visible-xs-block 單線邊框"></div>
            <div class="col-xs-6 col-sm-4 單線邊框">.col-xs-6 .col-sm-4</div>
          </div>
        </div>
        <br>
        <div class="container-fluid 單線邊框 橘色邊框">
          <div class="alert alert-success" role="alert">
            <p> .container-fluid 用於 100% 寬度的容器，橫跨可視區域的全部寬度。
              <b>此例要看的地方是，先把大小縮到xs，clearfix visible-xs-block的功能會在滿12欄位依最大高度起一新行</b>
            </p>
          </div>
          <div class="row">
            <div class="col-xs-6 col-sm-3 單線邊框">.col-xs-6 .col-sm-3
            重置你的可視區域大小，或是在你的手機瀏覽此範例。</div>
            <div class="col-xs-6 col-sm-3 單線邊框">.col-xs-6 .col-sm-3</div>
            <!-- 僅在所需的可視區域加入額外的 clearfix -->
            <div class="clearfix visible-xs-block"></div>
            <div class="col-xs-6 col-sm-3 單線邊框">.col-xs-6 .col-sm-3</div>
            <div class="col-xs-6 col-sm-3 單線邊框">.col-xs-6 .col-sm-3</div>
          </div>
          
        </div>
        <br>
        <div class="container-fluid 單線邊框 橘色邊框">
          <div class="alert alert-success" role="alert">
            <p> .container-fluid 用於 100% 寬度的容器，橫跨可視區域的全部寬度。
              <b>此例要看的地方是，先把大小縮到xs，沒有clearfix visible-xs-block的功能，欄位會依盡量塞畫面的方式來放欄位</b>
            </p>
          </div>
          <div class="row">
            <div class="col-xs-6 col-sm-3 單線邊框">.col-xs-6 .col-sm-3
            重置你的可視區域大小，或是在你的手機瀏覽此範例。</div>
            <div class="col-xs-6 col-sm-3 單線邊框">.col-xs-6 .col-sm-3</div>
            <div class="col-xs-6 col-sm-3 單線邊框">.col-xs-6 .col-sm-3</div>
            <div class="col-xs-6 col-sm-3 單線邊框">.col-xs-6 .col-sm-3</div>
          </div>
          
        </div>
        <br>
        <div class="container-fluid 單線邊框 橘色邊框">
          <div class="alert alert-success" role="alert">
            <p><b>這例的重點是位移offset的設定，也可以設定0，offset的設定值一樣是達到最小值生效，下一個最小值可以蓋過去</b></p>
          </div>
          <div class="row">
            <div class="col-sm-5 col-md-6 單線邊框">.col-sm-5 .col-md-6</div>
            <div class="col-sm-5 col-sm-offset-2 col-md-6 col-md-offset-0 單線邊框">.col-sm-5 .col-sm-offset-2 .col-md-6 .col-md-offset-0</div>
          </div>
          <div class="row">
            <div class="col-sm-6 col-md-5 col-lg-6 單線邊框">.col-sm-6 .col-md-5 .col-lg-6</div>
            <div class="col-sm-6 col-md-5 col-md-offset-2 col-lg-6 col-lg-offset-0 單線邊框">.col-sm-6 .col-md-5 .col-md-offset-2 .col-lg-6 .col-lg-offset-0</div>
          </div>
          
        </div>
        
        <div class="container-fluid 單線邊框 橘色邊框">
          <div class="alert alert-success" role="alert">
            <p><b>這例的重點是，row中有row的巢狀欄位，可以看到設了佔10欄的欄位(sm以上)裡的巢狀欄位，變小會改比例(xs)，總長10個欄位</b></p>
          </div>
          <div class="row">
            <div class="col-sm-10 單線邊框">
              Level 1: .col-sm-10，純文字會因div換行
              <div class="row">
                <div class="col-xs-8 col-sm-6 單線邊框">
                  Level 2: .col-xs-8 .col-sm-6
                </div>
                <div class="col-xs-4 col-sm-6 單線邊框">
                  Level 2: .col-xs-4 .col-sm-6
                </div>
              </div>
            </div>
          </div>
        </div>
        
        <div class="container-fluid 單線邊框 橘色邊框">
          <div class="alert alert-success" role="alert">
            <p><b>這例的重點是，欄位排序，可以加入push或是pull的css，改變欄位，但我覺得少用，感覺掌控度不高</b>
              說明：第一欄本來是1-9，push3後變4-12，第2欄本來是10-12，pull9後變1-3，我覺得用起來比較像offset
              ，只是offset是會佔位，這個push和pull不佔位只是本來位置的偏移，我是這樣解讀的
            </p>
          </div>
          <div class="row">
            <div class="col-md-9 col-md-push-3 單線邊框">.col-md-9 .col-md-push-3</div>
            <div class="col-md-3 col-md-pull-9 單線邊框">.col-md-3 .col-md-pull-9</div>
          </div>
        </div>
        
        
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
            <p><b>列表出h1到h6的顯示變化和small tag的第2字體的變化</b></p>
          </div>
          <h1>h1. 36px <small>small text font-size: 65%;</small></h1>
          <h2>h2. 30px <small>small text font-size: 65%;</small></h2>
          <h3>h3. 24px <small>small text font-size: 65%;</small></h3>
          <h4>h4. 18px <small>small text font-size: 65%;</small></h4>
          <h5>h5. 14px <small>small text font-size: 65%;</small></h5>
          <h6>h6. 12px <small>small text font-size: 65%;</small></h6>
        </div>
        <br>
        <div class="container-fluid 單線邊框 橘色邊框">
          <div class="alert alert-success" role="alert">
            <p><b>body 和 p預設 font-size 是 14px，line-height 是 1.428 ，p 設置了一個 1/2 行高（預設 10px）的底部邊距（margin）值</b></p>
          </div>
          <p class="單線邊框">p 第一行</p>
          <p class="單線邊框">p 第二行，觀察一下行高和底部有沒有1/2行高的margin，我是看不太出來啦，就算了</p>
          <div class="alert alert-success" role="alert">
            <p><b>lead 類別，製作一個讓段落突出的效果（字型依螢幕大小放大，其它如右）(font-weight: 300;line-height: 1.4;)</b></p>
            <p><b>mark 標籤以醒目提示文字內容。</b></p>
          </div>
          <p class="單線邊框">p 裡面的sapn <span class="lead">加入了lead 類別，效果就是這樣</span>，另入<mark>mark tag的效果就是這樣黃黃的</mark></p>
          <div class="alert alert-success" role="alert">
            <p><b>del標籤表明此文字區塊已被刪除。</b></p>
            <p><b>s標籤用於指出此文字區塊已經不再和段落有相關聯。</b></p>
            <p><b>ins標籤，用來指出被額外加入至文件的文字。</b></p>
            <p><b>u 標籤以呈現底線文字效果。</b></p>
          </div>
          <p><del>del標籤的效果</del>和<s>s標籤的效果</s>相同</p>
          <p><ins>ins標籤的效果</ins>和<u>u標籤的效果</u>我看起來認為相同</p>
          <div class="alert alert-success" role="alert">
            <p><b>small標籤將被設置為父容器的 85% 大小。font-size: 85%;</b></p>
            <p><b>strong標籤，使用粗體來強調某一段文字，b標籤同效果無語義。</b></p>
            <p><b>em 標籤，使用斜體來強調某一段文字。i標籤同效果無語義。</b></p>
          </div>
          <p><small>small標籤的效果</small>被設置為父容器的 85% 大小font-size: 85%;</p>
          <p><strong>strong標籤的效果</strong>和<b>b標籤的效果</b>相同</p>
          <p><em>em標籤的效果</em>和<i>i標籤的效果</i>相同</p>
          
          
          
        </div>
        <br>
        <div class="container-fluid 單線邊框 橘色邊框">
          <div class="alert alert-success" role="alert">
            <p><b>text align對齊相關的class的應用</b></p>
          </div>
          <p class="text-left">text-left類別靠左對齊文字。</p>
          <p class="text-center">text-center類別置中對齊文字。</p>
          <p class="text-right">text-right類別靠右對齊文字。</p>
          <p class="text-justify">text-justify類別平均對齊文字.text-justify 類別僅對英文有效。中文要用很麻煩，不想研究應該沒什麼用</p>
          <p class="text-nowrap">text-nowrap類別不換行文字類別不換行文字類別不換行文字類別不換行文字。</p>
          <div class="alert alert-success" role="alert">
            <p><b>text 轉大小寫相關的class的應用</b></p>
          </div>
          <p class="text-lowercase">TEXT-lowercase轉（全小寫）</p>
          <p class="text-uppercase">text-uppercase轉（全大寫）</p>
          <p class="text-capitalize">text-capitalize轉（字首大寫）</p>
          
          
          <div class="alert alert-success" role="alert">
            <p><b>abbr 標籤，縮寫，要有title屬性為未縮寫內容，標籤content為縮寫內容</b></p>
            <p><b>initialism 類別，應用到段落開頭的縮寫，font-size: 90%;text-transform: uppercase;</b></p>
            <p><b>blockquote標籤，表示引用區塊，font-size: 17.5px;</b></p>
            <p><b>footer標籤，在blockquote內字會變小變顏色，搭配cite標籤效果同abbr，來顯示引用的資料</b></p>
            <p><b>加入 .blockquote-reverse 類別到 blockquote 標籤中(text-align: right;)，那麼內容會靠右對齊呈現。</b></p>
          </div>
          <p>abbr 標籤效果如右，<abbr title="這是沒有縮寫的資料">把滑鼠停在此</abbr></p>
          <p>abbr 標籤+initialism 類別效果如右，<abbr title="這是沒有縮寫的資料" class="initialism">you can 把滑鼠停在此</abbr></p>
          <blockquote>
            <p>blockquote 的效果，左邊會外一條引用線border 5px</p>
          <footer>footer標籤，資料引用cite標籤如右：<cite title="引用來源是什麼鬼不告訴你">我的引用</cite></footer>
        </blockquote>
        <blockquote class="blockquote-reverse">
          <p>blockquote 的效果，左邊會外一條引用線border 5px</p>
        <footer>footer標籤，資料引用cite標籤如右：<cite title="引用來源是什麼鬼不告訴你">我的引用</cite></footer>
      </blockquote>
      
      
    </div>
    
    <br>
    <div class="container-fluid 單線邊框 橘色邊框">
      <div class="alert alert-success" role="alert">
        <p><b>無序清單的樣式展現ul</b></p>
        <p><b>有序清單的樣式展現ul改成ol</b></p>
        <p><b>移除樣式用class="list-unstyled"，只對當層有用，不換行用class="list-inline"</b></p>
      </div>
      <ul>
        <li>清單1</li>
        <li>清單2</li>
        <li>清單3<ul><li>子清單1</li><li>子清單2</li><li>子清單3<ul><li>孫清單1</li><li>孫清單2</li><li>孫清單3</li><li>孫清單4</li></ul></li><li>子清單4</li></ul></li>
        <li>清單4</li>
      </ul>
      <ol>
        <li>清單1</li>
        <li>清單2</li>
        <li>清單3<ol><li>子清單1</li><li>子清單2</li><li>子清單3<ol><li>孫清單1</li><li>孫清單2</li><li>孫清單3</li><li>孫清單4</li></ol></li><li>子清單4</li></ol></li>
        <li>清單4</li>
      </ol>
      <ul class="list-unstyled list-inline 單線邊框">
        <li>無樣式清單1</li>
        <li>無樣式清單2<ul><li>無樣式子清單1</li><li>無樣式子清單2</li></ul></li>
        <li>無樣式清單3</li>
      </ul>
      
    </div>
    <br>
    <div class="container-fluid 單線邊框 橘色邊框">
      <div class="alert alert-success" role="alert">
        <p><b>術語清單，外層用dl，子層用dt(專業術語)接dd(相關描述)</b></p>
        <p><b>加入dl-horizontal類別，拉螢幕試試，大中小會拆行和排版的變化</b></p>
      </div>
      <dl class="單線邊框">
        <dt class="單線邊框">專業術語1</dt>
        <dd class="單線邊框">相關描述1</dd>
        <dt class="單線邊框">專業術語2</dt>
        <dd class="單線邊框">相關描述2</dd>
        <dt class="單線邊框">專業術語3</dt>
        <dd class="單線邊框">相關描述3</dd>
      </dl>
      <dl class="dl-horizontal 單線邊框">
        <dt class="單線邊框">專業術語1</dt>
        <dd class="單線邊框">相關描述1相關描述1相關描述1相關描述1相關描述1相關描述1相關描述1相關描述1相關描述1相關描述1</dd>
        <dt class="單線邊框">專業術語2</dt>
        <dd class="單線邊框">相關描述2相關描述2相關描述2相關描述2相關描述2相關描述2相關描述2相關描述2相關描述2相關描述2相關描述2</dd>
        <dt class="單線邊框">專業術語3</dt>
        <dd class="單線邊框">相關描述3相關描述3相關描述3相關描述3相關描述3相關描述3相關描述3相關描述3相關描述3相關描述3相關描述3</dd>
      </dl>
      
    </div>
    <br>
    <div class="container-fluid 單線邊框 橘色邊框">
      <div class="alert alert-success" role="alert">
        <p><b>code標籤，用來表示程式碼font-size: 90%;color:#c7254e;background-color: #f9f2f4;......</b></p>
        <p><b>pre-scrollable類別，max-height: 340px;overflow-y: scroll;</b></p>
        <p><b>kbd標籤來指出要經由鍵盤來輸入的內容。font-size: 90%;color: #fff;background-color: #333;......</b></p>
        <p><b>var標籤用來包變數，samp標籤用來包電腦的輸出，由於樣式改變很小，就不做範例了</b></p>
      </div>
      <p>code標籤<code>public static void main (String args){<br>//hello world<br>}</code></p>
      純pre如下，使用pre+code標籤看不出任何效果
    <pre class="pre-scrollable">public static void main (String args){<br>//hello world<br>}</pre>
    <p>kbd單一使用，key <kbd>ipconfig</kbd> 和複合使用 <kbd><kbd>ctrl</kbd> + <kbd>c</kbd></kbd></p>
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
<html lang="zh-Hant-TW">
  <head>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../css/mycss.css">
    <script src="js/jquery-1.12.4.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </head>
  <div class="container-fluid 單線邊框 橘色邊框">
    <div class="alert alert-success" role="alert">
      <p><b>table類別，會把裡面的th、td調整如右padding: 8px;line-height: 1.42857143;vertical-align: top;border-top: 1px solid #ddd</b></p>
      <p><b>table-striped類別，單數例變色，ie8以下不支援，tr:nth-child(odd){background-color: #f9f9f9;}</b></p>
    </div>
    加上class=table的表格
    <table class="table table-striped">
      <caption>Optional 表格標題選填.</caption>
      <thead>
        <tr>
          <th>#</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Username</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>1</td>
          <td>Mark</td>
          <td>Otto</td>
          <td>@mdo</td>
        </tr>
        <tr>
          <td>2</td>
          <td>Jacob</td>
          <td>Thornton</td>
          <td>@fat</td>
        </tr>
        <tr>
          <td>3</td>
          <td>Larry</td>
          <td>the Bird</td>
          <td>@twitter</td>
        </tr>
      </tbody>
    </table>
    <div class="alert alert-success" role="alert">
      <p><b>table-bordered類別，加上邊框 border: 1px solid #ddd;</b></p>
      <p><b>table-hover類別，hover變色，.table-hover>tbody>tr:hover {background-color: #f5f5f5;}</b></p>
    </div>
    加上class=table的表格
    <table class="table table-bordered table-hover">
      <caption>Optional 表格標題選填.</caption>
      <thead>
        <tr>
          <th>#</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Username</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>1</td>
          <td>Mark</td>
          <td>Otto</td>
          <td>@mdo</td>
        </tr>
        <tr>
          <td>2</td>
          <td>Jacob</td>
          <td>Thornton</td>
          <td>@fat</td>
        </tr>
        <tr>
          <td>3</td>
          <td>Larry</td>
          <td>the Bird</td>
          <td>@twitter</td>
        </tr>
      </tbody>
    </table>
    <div class="alert alert-success" role="alert">
      <p><b>table-condensed類別，縮小間距讓表格更緊實，th和td padding: 5px;</b></p>
      <p><b>.active類別  當滑鼠移入某個 row 或儲存格（cell）時設置顏色。background-color: #f5f5f5;</b></p>
      <p><b>.success類別 指出一個成功或積極的動作。background-color: #dff0d8;</b></p>
      <p><b>.info類別  background-color: #d9edf7;</b></p>
      <p><b>.warning類別 指出一個需要注意的警告。background-color: #fcf8e3;</b></p>
      <p><b>.danger類別  指出一個危險或潛在有害的行為。background-color: #f2dede;</b></p>
    </div>
    加上class=table的表格
    <table class="table table-condensed">
      <caption>Optional 表格標題選填.</caption>
      <thead>
        <tr>
          <th>#</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Username</th>
        </tr>
      </thead>
      <tbody>
        <tr >
          <td>1</td>
          <td>沒有設class</td>
          <td>Otto</td>
          <td>@mdo</td>
        </tr>
        <tr class="active">
          <td>2</td>
          <td>class="active"</td>
          <td>Thornton</td>
          <td>@fat</td>
        </tr>
        <tr class="success">
          <td>3</td>
          <td>class="success"</td>
          <td>the Bird</td>
          <td>@twitter</td>
        </tr>
        <tr class="info">
          <td>1</td>
          <td>class="info"</td>
          <td>Otto</td>
          <td>@mdo</td>
        </tr>
        <tr class="warning">
          <td>2</td>
          <td>class="warning"</td>
          <td>Thornton</td>
          <td>@fat</td>
        </tr>
        <tr class="danger">
          <td>3</td>
          <td>class="danger"</td>
          <td>the Bird</td>
          <td>@twitter</td>
        </tr>
      </tbody>
    </table>
    <div class="alert alert-success" role="alert">
      <p><b>table-responsive類別，實作自適應表格，上層用div設class=table-responsive，就可以在小於768時長出水平捲軸(overflow-x: auto;)</b></p>
      <p><b>firefox中，fieldset會有問題，要自行修正@-moz-document url-prefix() {  fieldset { display: table-cell; }}</b></p>
    </div>
    <div class="table-responsive">
      <table class="table table-bordered">
        <caption></caption>
        <thead>
          <tr>
            <th>#</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Username</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>1</td>
            <td>Mark</td>
            <td>Otto</td>
            <td>@mdo</td>
          </tr>
        </tbody>
      </table>
      
    </div>
    
  </div>
  <br>
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
        <p><b>help-block類別，說明註解文字，適用p標籤，display: block;margin-top: 5px;margin-bottom: 10px;color: #737373;</b></p>
        <p><b>form-control類別，會設置input(check和file不用設？)、textarea、select相關的寬100%，行高、字型大小、背景色、外框圓角…</b></p>
        <p><b>form-group類別，適合包一個lable和一個輸入的form-control，文件說包裝在一起以取得最佳的排列組合，我認為只是控元件間隔而已，margin-bottom: 15px;</b></p>
        <p><b>checkbox and radio類別，position: relative;display: block;margin-top: 10px;margin-bottom: 10px;;</b></p>
        <p><b>form標籤的role="form"，是為了無障礙閱讀器的加強功能而已，就加上吧</b></p>
        <p><b>form-group-lg和input-lg的效果相同，只是廣域設在form，form-group-sm同理就不測了</b></p>
        <p><b>總結：form標籤加上role="form"，輸入欄div的class用form-group，input輸入欄的class用form-control，checkbox和radio的div的class用checkbox和radio</b></p>
      </div>
      <form role="form" class="form-group-lg">
        <div class="form-group 單線邊框">
          <label for="exampleInputEmail1">電子郵件</label>
          <input type="email" class="form-control" id="exampleInputEmail1" placeholder="輸入電子郵件">
        </div>
        <div class="form-group 單線邊框">
          <label for="exampleInputPassword1">密碼</label>
          <input type="密碼" class="form-control" id="exampleInputPassword1" placeholder="Password">
        </div>
        <div class="form-group 單線邊框">
          <label for="exampleInputFile">檔案上傳</label>
          <input type="file" id="exampleInputFile">
          <p class="help-block">在此示範區塊層級輔助說明文字。</p>
        </div>
        <div class="checkbox 單線邊框">
          <label>
            <input type="checkbox"> 勾選我
          </label>
        </div>
        <button type="submit" class="btn btn-default">送出</button>
      </form>
    </div>
    <br>
    <div class="container-fluid 單線邊框 橘色邊框">
      <div class="alert alert-success" role="alert">
        <p><b>form-inline類別，子元件繼承position: relative;display: table;border-collapse: separate;</b></p>
        <p><b>form-inline類別 (form-group,checkbox,radio,form-control)類別改變了div為inline-block(768px以上)，才能一行多個div,input</b></p>
        <p><b>sr-only類別，不顯示，閱讀器會唸出來，每個輸入欄都有label應該是標準做法</b></p>
        <p><b>input-group後補，在元件的單元再看看，input-group不能和form-group混用，但可放到form-group中</b></p>
        <p><b>總結：不要用，因為加上form-inline，元件width會被設成auto，要改的話要自已想辦法設width</b></p>
      </div>
      <form class="form-inline" role="form">
        <div class="form-group 單線邊框">
          <div class="input-group 單線邊框 橘色邊框">
            <label class="sr-only" for="exampleInputEmail2">電子郵件</label>
            <div class="input-group-addon">@</div>
            <input type="email" class="form-control" id="exampleInputEmail2" placeholder="輸入電子郵件">
          </div>
        </div>
        <div class="form-group 單線邊框">
          <label class="sr-only" for="exampleInputPassword2">密碼</label>
          <input type="password" class="form-control" id="exampleInputPassword2" placeholder="密碼">
        </div>
        <div class="checkbox 單線邊框">
          <label>
            <input type="checkbox"> 記住我
          </label>
        </div>
        <button type="submit" class="btn btn-default">登入</button>
      </form>
    </div>
    <br>
    <div class="container-fluid 單線邊框 橘色邊框">
      <div class="alert alert-success" role="alert">
        <p><b>form-horizontal類別，用來12個col排版表單元件(768px以上有用)</b></p>
        <p><b>control-label類別，form-horizontal底下會文字右靠，padding-top: 7px;margin-bottom: 0;text-align: right;</b></p>
        <p><b>label可以直接設col，我想input和(checkbox,radio的div)都視為元件，再包1層div設col</b></p>
        <p><b>form-control-static類別，適合放在p標籤，用來顯示純文字</b></p>
        <p><b>總結：感覺應該不錯用，1行pc分2-4欄，平板2欄，手機1欄</b></p>
      </div>
      <form class="form-horizontal" role="form">
        <div class="form-group 單線邊框">
          <label for="inputEmail3" class="col-sm-2 control-label 單線邊框 橘色邊框">電子郵件</label>
          <div class="col-sm-10 單線邊框 橘色邊框">
            <p class="form-control-static">靜態控制email@example.com</p>
          </div>
        </div>
        <div class="form-group 單線邊框">
          <label for="inputPassword3" class="col-sm-2 control-label 單線邊框 橘色邊框">密碼</label>
          <div class="col-sm-10 單線邊框 橘色邊框">
            <input type="password" class="form-control" id="inputPassword3" placeholder="密碼">
          </div>
        </div>
        <div class="form-group 單線邊框">
          <div class="col-sm-offset-2 col-sm-10 單線邊框 橘色邊框">
            <div class="checkbox">
              <label>
                <input type="checkbox"> 記住我
              </label>
            </div>
          </div>
        </div>
        <div class="form-group 單線邊框">
          <div class="col-sm-offset-2 col-sm-10 單線邊框 橘色邊框">
            <button type="submit" class="btn btn-default">登入</button>
          </div>
        </div>
      </form>
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
        <p><b>input 的type的東西有夠多，以後再用w3c的例子補完</b></p>
        <p><b>checkbox-inline和radio-inline，display: inline-block;和字型之類的…</b></p>
        <p><b>checkbox的label空值的時候可設定aria-label告訴閱讀器</b></p>
      </div>
      type=text
      <input type="text" class="form-control" placeholder="請輸入文字">
      <input class="form-control"  type="text" placeholder="禁用的樣式..." disabled>
      <input class="form-control" type="text" placeholder="唯讀的樣式，可focus…" readonly>
      <input class="form-control input-lg" type="text" placeholder=".input-lg，大字型的input">
	  <input class="form-control" type="text" placeholder="Default input，預設大小的input">
	  <input class="form-control input-sm" type="text" placeholder=".input-sm，小型的input">
      <span id="helpBlock" class="help-block">help-block類別的文字樣式，用在表單的輔助說明用的</span>
      <hr>
      checkbox
      <div class="checkbox">
        <label>
          <input type="checkbox" value="">
          checkbox1
        </label>
      </div>
      <div class="checkbox disabled">
        <label>
          <input type="checkbox" value="" disabled>
          checkbox disabled
        </label>
      </div>
      <div class="radio">
        <label>
          <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>
          radio  value="option1"
        </label>
      </div>
      <div class="radio">
        <label>
          <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
          radio  value="option2"
        </label>
      </div>
      <div class="radio disabled">
        <label>
          <input type="radio" name="optionsRadios" id="optionsRadios3" value="option3" disabled>
          radio disabled
        </label>
      </div>
      設定成inline
      <label class="checkbox-inline">
        <input type="checkbox" id="inlineCheckbox1" value="option1"> 1
      </label>
      <label class="checkbox-inline">
        <input type="checkbox" id="inlineCheckbox2" value="option2"> 2
      </label>
      <label class="checkbox-inline">
        <input type="checkbox" id="inlineCheckbox3" value="option3"> 3
      </label>
      <label class="radio-inline">
        <input type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1"> 1
      </label>
      <label class="radio-inline">
        <input type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2"> 2
      </label>
      <label class="radio-inline">
        <input type="radio" name="inlineRadioOptions" id="inlineRadio3" value="option3"> 3
      </label>
      
      
      <hr>
      textarea 會有錯誤，所以用jsp註解掉無法看效果
      <%--  <textarea class="form-control" rows="3"></textarea> --%>
      <hr>
      label沒有填值的時候，可在aria-label設定值告訴閱讀器
      <div class="checkbox">
        <label>
          <input type="checkbox" id="blankCheckbox" value="option1" aria-label="...">
        </label>
      </div>
      <div class="radio">
        <label>
          <input type="radio" name="blankRadio" id="blankRadio1" value="option1" aria-label="...">
        </label>
      </div>
      
      
    </div>
    
    <br>
    <div class="container-fluid 單線邊框 橘色邊框">
      <div class="alert alert-success" role="alert">
        <p><b>很單純地展現單選和複選的select</b></p>
        <p><b>fieldset標籤有相容性問題，所以不建議使用啦</b></p>
      </div>
      <select class="form-control">
        <option>1</option>
        <option>2</option>
        <option>3</option>
        <option>4</option>
        <option>5</option>
      </select>
      <select multiple class="form-control">
        <option>1</option>
        <option>2</option>
        <option>3</option>
        <option>4</option>
        <option>5</option>
      </select>
      <br>
      
      <div class=" 單線邊框 ">
        使用fieldset，disabled後，裡面的就都disabled，連結部分ie11以下有問題，要用 JavaScript 去禁用連結
        ie9以下也不支援fieldset元素中設置 disabled 屬性，較安全性的作法是，使用自訂的 JavaScript 去禁用 fieldset
        <fieldset disabled >
          <div class="form-group">
            <label for="disabledTextInput">禁用 input</label>
            <input type="text" id="disabledTextInput" class="form-control" placeholder="Disabled input">
          </div>
          <div class="form-group">
            <label for="disabledSelect">禁用下拉選單</label>
            <select id="disabledSelect" class="form-control">
              <option>Disabled select</option>
            </select>
          </div>
          <div class="checkbox">
            <label>
              <input type="checkbox"> 禁用 checkbox
            </label>
          </div>
          <button type="submit" class="btn btn-primary">禁用按鈕</button>
        </fieldset>
      </div>
    </div>
    <br>
    <div class="container-fluid 單線邊框 橘色邊框">
      <div class="alert alert-success" role="alert">
        <p><b>has-success類別，改變底下控制項的顏色，color: #3c763d;</b></p>
        <p><b>has-warning類別，改變底下控制項的顏色，color: #8a6d3b;</b></p>
        <p><b>has-error類別，改變底下控制項的顏色，color: #a94442;</b></p>
        <p><b>has-xxx類別，對應到checkbox或radio的div層(視div)層為控制項</b></p>
        <p><b>control-label類別，設置在label上面，會對應has-xxx 改變顏色</b></p>
      </div>
      <div class="form-group has-success">
        <label class="control-label" for="inputSuccess1">Input成功</label>
        <input type="text" class="form-control" id="inputSuccess1">
      </div>
      <div class="form-group has-warning">
        <label class="control-label" for="inputWarning1">Input警告</label>
        <input type="text" class="form-control" id="inputWarning1">
      </div>
      <div class="form-group has-error">
        <label class="control-label" for="inputError1">Input錯誤</label>
        <input type="text" class="form-control" id="inputError1">
      </div>
      <div class="has-success">
        <div class="checkbox">
          <label>
            <input type="checkbox" id="checkboxSuccess" value="option1">
            Checkbox成功
          </label>
        </div>
      </div>
      <div class="has-warning">
        <div class="checkbox">
          <label>
            <input type="checkbox" id="checkboxWarning" value="option1">
            Checkbox警告
          </label>
        </div>
      </div>
      <div class="has-error">
        <div class="checkbox">
          <label>
            <input type="checkbox" id="checkboxError" value="option1">
            Checkbox錯誤
          </label>
        </div>
      </div>
      
      
      
    </div>
    <br>
    <div class="container-fluid 單線邊框 橘色邊框">
      <div class="alert alert-success" role="alert">
        <p><b>sr-only類別，會不顯示但是閱讀器會念</b></p>
        <p><b>aria-hidden="true"，閱讀器會忽略這個控制項</b></p>
        <p><b>aria-describedby，可以指個id，閱讀器會去找那個id</b></p>
        <p><b>has-feedback類別，會將div的position: relative;</b></p>
        <p><b>form-control-feedback類別，position: absolute;right: 0;z-index: 2</b></p>
        <p><b>glyphicon glyphicon-ok，原理是先設字型檔後，用before寫字產生圖示吧，反正依樣畫胡盧就好了</b></p>
      </div>
      <div class="form-group has-success has-feedback">
        <label class="control-label" for="inputSuccess2">Input with success</label>
        <input type="text" class="form-control" id="inputSuccess2" aria-describedby="inputSuccess2Status">
        <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
        <span id="inputSuccess2Status" class="sr-only">(success)</span>
      </div>
      <div class="form-group has-warning has-feedback">
        <label class="control-label" for="inputWarning2">Input with warning</label>
        <input type="text" class="form-control" id="inputWarning2" aria-describedby="inputWarning2Status">
        <span class="glyphicon glyphicon-warning-sign form-control-feedback" aria-hidden="true"></span>
        <span id="inputWarning2Status" class="sr-only">(warning)</span>
      </div>
      <div class="form-group has-error has-feedback">
        <label class="control-label" for="inputError2">Input with error</label>
        <input type="text" class="form-control" id="inputError2" aria-describedby="inputError2Status">
        <span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span>
        <span id="inputError2Status" class="sr-only">(error)</span>
      </div>
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
        <p><b>按鈕的樣式的展式</b></p>
        <p><b>作為最佳實踐，我們強烈建議盡可能的使用button元素以確保在跨瀏覽器上能有一致的呈現</b></p>
      </div>
<button type="button" class="btn btn-default">Default標準按鈕btn-default</button>
<br>
<button type="button" class="btn btn-primary">Primary主要的操作項目btn-primary</button>
<br>
<button type="button" class="btn btn-success">Success成功或積極的操作btn-success</button>
<br>
<button type="button" class="btn btn-info">Info訊息提示btn-info</button>
<br>
<button type="button" class="btn btn-warning">Warning指出應謹慎採取此一行動btn-warning</button>
<br>
<button type="button" class="btn btn-danger">Danger指出危險或潛在負面作用的行動btn-danger</button>
<br>
<button type="button" class="btn btn-link">Link連結並同時保持按鈕行為btn-link</button>      
<br>
  <button type="button" class="btn btn-primary btn-lg">大按鈕btn-lg</button>
<br>
  <button type="button" class="btn btn-success">預試按鈕</button>
<br>
  <button type="button" class="btn btn-info btn-sm">小按鈕btn-sm</button>
<br>
  <button type="button" class="btn btn-warning btn-xs">最小按鈕btn-xs</button>
<br>
  <button type="button" class="btn btn-danger btn-block">填滿寬度的按鈕btn-block</button>
<br>
 <button type="button" class="btn btn-info"  disabled="disabled">disabled的樣式，對比右邊的按鈕</button>
 <button type="button" class="btn btn-info">對比右邊的按鈕，按下去比對樣式</button>
  <button type="button" class="btn btn-info active">展示active按下去的class</button>

 <p>雖然按鈕類別可以套用至 a 和button元素上，但僅有button元素是被巡覽列和巡覽元件所支援，
 .disabled 類別使用 pointer-events: none (css3滑鼠事件會穿透到下面的元件)樣式設置去禁用 a 的連結功能，有相容問題
 </p>
 <a href="http://www.kimo.com.tw" class="btn btn-primary" role="button">a標籤button樣式，可用#id來link錨點</a>
 <a href="http://www.kimo.com.tw" class="btn btn-primary disabled" role="button">a標籤button樣式，加入disable樣式，也真的會disable</a>
    </div>
    <br>
    
    
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
        <p><b>aaaaaaaaaaaaaaaaa</b></p>
      </div>
      加入 .img-responsive 類別，套用display: block;max-width: 100%; 和 height: auto; 屬性
      <img src="../css/2.png" class="img-responsive" alt="Responsive image">
      Internet Explorer 8 不支援 CSS3 的圓角屬性。
      <br>
      img-rounded類別，圓角圖border-radius: 6px;
      <img src="../css/2.png" alt="..." class="img-responsive img-rounded">
      img-circle類別，圖形圖border-radius: 50%;
<img src="../css/2.png" alt="..." class="img-responsive img-circle">
img-thumbnail類別，圖片快取縮圖樣式，display: inline-block;會蓋過img-responsive的block
，padding: 4px;background-color: #fff;border: 1px solid #ddd;border-radius: 4px;
<br>
<img src="../css/2.png" alt="..." class="img-responsive img-thumbnail">
      
    </div>
    <br>
    
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
        <p><b>顯示一些顏色代表的意義而已</b></p>
      </div>
      <p class="text-muted">text-muted 靜態文字</p>
<p class="text-primary">text-primary 主要的重點文字</p>
<p class="text-success">text-success 成功文字</p>
<p class="text-info">text-info 訊息文字</p>
<p class="text-warning">text-warning 警告文字</p>
<p class="text-danger">text-danger 危險文字</p>
<p class="bg-primary">bg-primary重點背景</p>
<p class="bg-success">bg-success成功背景</p>
<p class="bg-info">bg-info訊息背景</p>
<p class="bg-warning">bg-warning警告背景</p>
<p class="bg-danger">bg-danger危險背景</p>     
    </div>
    <br>
    <div class="container-fluid 單線邊框 橘色邊框">
      <div class="alert alert-success" role="alert">
        <p><b>顯示一些特別的圖示</b></p>
      </div>
      <div class="單線邊框" style="width:200px">
      關閉按鈕(float: right;)
      <button type="button" class="close"><span aria-hidden="true">x</span><span class="sr-only">Close</span></button>
      </div>
      三角下拉caret(用border畫出來的)<span class="caret"></span>
    
    <div class="center-block" style="width:200px;background-color:#aaa;">center-block類別，用margin置中，要width小於容器才有用</div>  
    <div class="單線邊框" style="width:800px;">
    <div class="pull-right">pull-right類別，右靠 float: right !important;</div>
    <div class="pull-left">pull-left類別，左靠 float: left !important;</div>
    </div>
    <p style="background-color:aqua;color:red;">沒有clearfix的結果</p>
 
    <div class="clearfix 單線邊框" style="width:800px;">
    <div class="pull-right">pull-right類別，右靠 float: right !important;</div>
    <div class="pull-left">pull-left類別，左靠 float: left !important;</div>
    </div>
    <p style="background-color:aqua;color:red;">有clearfix的結果</p>
    <p>類別show(display: block !important;)</p>
    <p>類別hidden(display: none !important;visibility: hidden !important;)</p>
    <p>類別.invisible(visibility: hidden;)</p>
    <p class="is-visible">is-visible類別，表示顯示，is-hidden類別，表示不顯示，在table中會變成變色，在其它中會影嚮顯示</p>
    <p class="is-hidden">is-hidden類別，表示不顯示</p>
    <table class="table table-bordered table-hover">
    <tr>
    <td><span class="hidden-xs">hidden-xs 768以下(display: none!important;)</span></td>
    <td><span class="visible-xs-inline">visible-xs-inline 768以下顯示(display: inline!important;)</span></td>    
    <td><span class="visible-xs-inline-block">visible-xs-inline-block 768以下顯示(display: inline-block!important;)</span></td>
    <td><span class="visible-xs-block">visible-xs-block 768以下顯示(display: block!important;)</span></td>
    </tr>
    <tr>
    <td><span class="hidden-sm">hidden-sm 768-992(display: none!important;)</span></td>
    <td><span class="visible-sm-inline">visible-sm-inline 768-992顯示(display: inline!important;)</span></td>    
    <td><span class="visible-sm-inline-block">visible-sm-inline-block 768-992顯示(display: inline-block!important;)</span></td>
    <td><span class="visible-sm-block">visible-sm-block 768-992顯示(display: block!important;)</span></td>
    </tr>
    <tr>
    <td><span class="hidden-md">hidden-md 992-1200(display: none!important;)</span></td>
    <td><span class="visible-md-inline">visible-md-inline 992-1200顯示(display: inline!important;)</span></td>    
    <td><span class="visible-md-inline-block">visible-md-inline-block 992-1200顯示(display: inline-block!important;)</span></td>
    <td><span class="visible-md-block">visible-md-block 992-1200顯示(display: block!important;)</span></td>
    </tr>
    <tr>
    <td><span class="hidden-lg">hidden-md 1200以上(display: none!important;)</span></td>
    <td><span class="visible-lg-inline">visible-md-inline 1200以上(display: inline!important;)</span></td>    
    <td><span class="visible-lg-inline-block">visible-md-inline-block 1200以上(display: inline-block!important;)</span></td>
    <td><span class="visible-lg-block">visible-md-block 1200以上(display: block!important;)</span></td>
    </tr>
    </table>
    列印如下
    <table class="table table-bordered table-striped responsive-utilities">
      <thead>
        <tr>
          <th>類別<!--Classes--></th>
          <th>瀏覽器<!--Browser--></th>
          <th>列印<!--Print--></th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <th>
            <code>.visible-print-block</code><br>
            <code>.visible-print-inline</code><br>
            <code>.visible-print-inline-block</code>
          </th>
          <td class="is-hidden">隱藏<!--Hidden--></td>
          <td class="is-visible">顯示<!--Visible--></td>
        </tr>
        <tr>
          <th><code>.hidden-print</code></th>
          <td class="is-visible">顯示<!--Visible--></td>
          <td class="is-hidden">隱藏<!--Hidden--></td>
        </tr>
      </tbody>
    </table>
    
	
	
	<br>
    
    
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