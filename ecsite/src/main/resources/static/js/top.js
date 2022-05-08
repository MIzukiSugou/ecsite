/*
 * ログアウトボタン押下時の処理です。
 */
function logout(){
  if(window.confirm('ログアウトしますか？')){
    document.forms[0].submit();
  }
  return false;
}
