function startRead(evt) {  
  var file = document.getElementById('file').files[0];
  if(file){
    if(file.type.match("image.*"))
    {
    getAsImage(file);
    alert("Name: "+file.name +"\n"+"Last Modified Date :"+file.lastModifiedDate);
    }
    else
    {
    getAsText(file);
    alert("Name: "+file.name +"\n"+"Last Modified Date :"+file.lastModifiedDate);
    }
    }
    evt.stopPropagation();
    evt.preventDefault();
}

function startReadFromDrag(evt) {
    var file = evt.dataTransfer.files[0];
    if (file) {
        if (file.type.match("image.*")) {
            getAsImage(file);
            alert("Name: " + file.name + "\n" + "Last Modified Date :" + file.lastModifiedDate);
        }
        else {
            getAsText(file);
            alert("Name: " + file.name + "\n" + "Last Modified Date :" + file.lastModifiedDate);
        }
    }
    evt.stopPropagation();
    evt.preventDefault();
}


function getAsText(readFile) {
        
  var reader = new FileReader();
  
  // Read file into memory as UTF-16      
  reader.readAsText(readFile, "UTF-8");
  
  // Handle progress, success, and errors
  reader.onprogress = updateProgress;
  reader.onload = loaded;
  reader.onerror = errorHandler;
}

function getAsImage(readFile) {
        
  var reader = new FileReader();
  
  // Read file into memory as UTF-16      
  reader.readAsDataURL(readFile);
  
  // Handle progress, success, and errors
  reader.onload = addImg;
}

function updateProgress(evt) {
  if (evt.lengthComputable) {
    // evt.loaded and evt.total are ProgressEvent properties
    var loaded = (evt.loaded / evt.total);
    
    if (loaded < 1) {
      // Increase the prog bar length
      // style.width = (loaded * 200) + "px";
    }
  }
}

function loaded(evt) {  
  // Obtain the read file data    
  var fileString = evt.target.result;
  $("#op").text(fileString);
  alert("file Loaded successfully");
  // Handle UTF-16 file dump
  if(utils.regexp.isChinese(fileString)) {
    //Chinese Characters + Name validation
  }
  else {
    // run other charset test
  }
  // xhr.send(fileString)     
}

function errorHandler(evt) {
  if(evt.target.error.name == "NotReadableError") {
    // The file could not be read
  }
}
function domagic(evt){
$("#draghere").css("background-color","green");
  evt.stopPropagation();
    evt.preventDefault();  
}

function addImg(imgsrc){
 var img = document.createElement('img');
  img.setAttribute("src",imgsrc.target.result);
  img.setAttribute("height","100");
  img.setAttribute("width","300");
  document.getElementById("op").insertBefore(img);
}

  var dropingDiv = document.getElementById('draghere');
  dropingDiv.addEventListener('dragover', domagic, false);
  dropingDiv.addEventListener('drop', startReadFromDrag, false);/**
 * 
 */