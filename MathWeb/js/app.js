//导航栏二级子菜单
window.onload=function(){
    addSubItem('nav_item');
}
function addSubItem(className){
    var classesname=document.getElementsByClassName(className);
    for(var i=0;i<classesname.length;i++){
        classesname[i].getElementsByTagName('a')[0].onmouseover=function(){
            var pNode=this.parentNode;
            pNode.getElementsByClassName('subnav')[0].style.display='block';
            pNode.getElementsByClassName('subnav')[0].onmouseover=function(){
                this.style.display='block';
            }
       }
        classesname[i].getElementsByTagName('a')[0].onmouseout=function(){
            var pNode=this.parentNode;
            pNode.getElementsByClassName('subnav')[0].style.display='none';
            pNode.getElementsByClassName('subnav')[0].onmouseout=function(){
                this.style.display='none';
            }
        }
    }
}
