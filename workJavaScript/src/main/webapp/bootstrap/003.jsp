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
        <a href="#id1">id1</a>
      </p>
      <p>
        <a href="#id2">id2</a>
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
      </textarea>
      <br>
      <!-- ******************************************************************************************** -->
      <button type="button" onclick="javascriptWindow(document.getElementById('id2').value );">測試2</button>
      <br>
      <textarea id="id2" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
      spellcheck="false">
</textarea>
<br>
<!-- ******************************************************************************************** -->
<button type="button" onclick="javascriptWindow(document.getElementById('id3').value );">測試3</button>
<br>
<textarea id="id3" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
spellcheck="false">
  </textarea>
  <br>
  <!-- ******************************************************************************************** -->
  <button type="button" onclick="javascriptWindow(document.getElementById('id4').value );">測試4</button>
  <br>
  <textarea id="id4" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
  spellcheck="false">
  </textarea>
  <br>
  <!-- ******************************************************************************************** -->
  <button type="button" onclick="javascriptWindow(document.getElementById('id5').value );">測試5</button>
  <br>
  <textarea id="id5" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
  spellcheck="false">
  
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