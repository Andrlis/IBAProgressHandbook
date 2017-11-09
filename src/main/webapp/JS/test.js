function buildUserTable() {
    var request = new XMLHttpRequest();
    request.onreadystatechange = function(){
        if (this.readyState == 4 && this.status == 200){
            console.log(eval(this.responseText));
        }
    }

    request.open("POST", "UserListData", true);
    request.send();
}