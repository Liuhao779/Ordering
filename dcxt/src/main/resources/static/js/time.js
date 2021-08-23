
var date = new Date();
onload = function () {
    var data = "";
    var startdate;
    var enddate;

    var day = date.getDay();
    switch (day){
        case 1:
            startdate = date.getDate();
            enddate = date.getDate()+6;
            break;
        case 2:
            startdate = date.getDate()-1;
            enddate = date.getDate()+5;
            break;
        case 3:
            startdate = date.getDate()-2;
            enddate = date.getDate()+4;
            break;
        case 4:
            startdate = date.getDate()-3;
            enddate = date.getDate()+3;
            break;
        case 5:
            startdate = date.getDate()-4;
            enddate = date.getDate()+2;
            break;
        case 6:
            startdate = date.getDate()-5;
            enddate = date.getDate()+1;
            break;
        case 7:
            startdate = date.getDate()-6;
            enddate = date.getDate();
            break;
    }
    var startmonth = date.getMonth()+1;
    var endmonth;
    if(date.getDate()+7<date.getDate()){
        endmonth = date.getMonth()+2;
    }else{
        endmonth = startmonth;
    }
    document.getElementById("time").innerHTML=startmonth+"."+startdate+"---"+endmonth+"."+enddate;

}