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
                                <pre>
                                                Bootstrap 所有 JavaScript 外掛都相依於 jQuery
                                                目前 Bootstrap 3 為了相容性考量，支援 jQuery 1.9.1 之後的版本，請勿使用 jQuery 2.x
                                                3.37好像有支援jquery3，以後再看看
                                                Internet Explorer 8(6-8?) 需要使用 Respond.js才能支援Media Query
                                                引入respond.min.js，但要在css的后面（越早引入越好，在ie下面看到页面闪屏的概率就越低，因为最初css会先渲染出来，如果respond.js加载得很后面，这时重新根据media query解析出来的css会再改变一次页面的布局等，所以看起来有闪屏的现象）
                                                Bootstrap 3 不支援舊版本 IE 相容性模式。為了確保 IE 是使用最新的呈現模式，考慮將下列 <meta> 加入你的頁面：
                                                ＜meta http-equiv="X-UA-Compatible" content="IE=edge"＞
                                                
    </pre>
    <div id="div0" align="center">
      <p>
        <a href="#id1">格線grid</a>
      </p>
      <p>
        <a href="#id2">顯示和排版</a>
      </p>
      <p>
        <a href="#id3">id3</a>
      </p>
      <p>
        <a href="#id4">id4</a>
      </p>
      <p>
        <a href="#id5">id5</a>
      </p>
      <p>
        <a href="#id6">id6</a>
      </p>
      <p>
        <a href="#id7">id7</a>
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
        <p><b>aaaaaaaaaaaaaaaaa</b></p>
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
  <script>
  
  </script>
  </textarea>
  <br>
  <!-- ******************************************************************************************** -->
  <button type="button" onclick="javascriptWindow(document.getElementById('id4').value );">測試4</button>
  <br>
  <textarea id="id4" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
  spellcheck="false">
  <script>
  
  </script>
  </textarea>
  <br>
  <!-- ******************************************************************************************** -->
  <button type="button" onclick="javascriptWindow(document.getElementById('id5').value );">測試5</button>
  <br>
  <textarea id="id5" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
  spellcheck="false">
  <script>
  
  </script>
  </textarea>
  <br>
  <!-- ******************************************************************************************** -->
  <button type="button" onclick="javascriptWindow(document.getElementById('id6').value );">測試6</button>
  <br>
  <textarea id="id6" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
  spellcheck="false">
  <script>
  
  </script>
  </textarea>
  <br>
  <!-- ******************************************************************************************** -->
  <button type="button" onclick="javascriptWindow(document.getElementById('id7').value );">測試7</button>
  <br>
  <textarea id="id7" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
  spellcheck="false">
  <script>
  
  </script>
  </textarea>
  <br>
  <!-- ******************************************************************************************** -->
  <button type="button" onclick="javascriptWindow(document.getElementById('id8').value );">測試8</button>
  <br>
  <textarea id="id8" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
  spellcheck="false">
  <script>
  
  </script>
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
  <script>
  
  </script>
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