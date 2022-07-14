// July 9 2021
// Julia Garant
// 3340 Summer
const items = [
    {
      filename:"assets/soccerball.png", // 1
      caption:"Soccer Ball",
      price: 9.55
    },{
      filename:"assets/hat.png",  // 2
      caption:"Hat",
      price: 11.99
    },{
      filename:"assets/boots.png",  // 3
      caption:"Boots",
      price: 14.95
    },{
      filename:"assets/glass.png",  // 4
      caption:"Wine Glass",
      price: 3.45
    },{
      filename:"assets/piggy.png",  // 5
      caption:"Piggy Bank",
      price: 10.35
    },{
      filename:"assets/watch.png",  // 6
      caption:"Watch",
      price: 22.35
    },{
      filename:"assets/carriage.png", // 7
      caption:"Old Carriage",
      price: 199.99
    },{
      filename:"assets/dagger.png", // 8
      caption:"Dagger",
      price: 45.99
    },{
      filename:"assets/vest.png", // 9
      caption:"Vest",
      price: 23.55
    },{
      filename:"assets/dress.png",  // 10
      caption:"Dress",
      price: 12.99
    },{
      filename:"assets/tire.png", // 11
      caption:"Tire",
      price: 249.95
    },{
      filename:"assets/wig.png", // 12
      caption:"Long Wig",
      price: 32.45
    }
  ]

  // Create random numbers for image population
  var uniqueRandNum = [];
  var randNum = Math.ceil(Math.random() * 100 )%12; //get value 1 [0]

  for (var i = 0; i < 6; i++) {
    while(uniqueRandNum.includes(randNum)){
      randNum = Math.ceil(Math.random() * 100 )%12; //generate next rand nums[1-5]
    }
    uniqueRandNum.push(randNum);
  }

  //Create the inners of the table
  var mainTable = document.getElementById("mainTable");
  var row1 = mainTable.insertRow(0);
  var row2 = mainTable.insertRow(1);

  var cell1 = row1.insertCell(0);
  var cell2 = row1.insertCell(1);
  var cell3 = row1.insertCell(2);

  var cell4 = row2.insertCell(0);
  var cell5 = row2.insertCell(1);
  var cell6 = row2.insertCell(2);

  cell1.innerHTML = "<img src=\"" + items[uniqueRandNum[0]].filename + "\" onclick=\"addToCart('c1','d1','p1')\" id = \"c1\"> <br> <label id=\"d1\">"+ items[uniqueRandNum[0]].caption +"</label>  $ <label id=\"p1\">" + items[uniqueRandNum[0]].price +"</label>";

  cell2.innerHTML = "<img src=\"" + items[uniqueRandNum[1]].filename + "\" onclick=\"addToCart('c2','d2','p2')\" id = \"c2\"> <br> <label id=\"d2\">"+ items[uniqueRandNum[1]].caption +"</label> $  <label id=\"p2\">" + items[uniqueRandNum[1]].price +"</label>";

  cell3.innerHTML = "<img src=\"" + items[uniqueRandNum[2]].filename + "\" onclick=\"addToCart('c3','d3','p3')\" id = \"c3\"> <br> <label id=\"d3\">"+ items[uniqueRandNum[2]].caption +"</label> $  <label id=\"p3\">" + items[uniqueRandNum[2]].price +"</label>";

  cell4.innerHTML = "<img src=\"" + items[uniqueRandNum[3]].filename + "\" onclick=\"addToCart('c4','d4','p4')\" id = \"c4\"> <br> <label id=\"d4\">"+ items[uniqueRandNum[3]].caption +"</label> $ <label id=\"p4\">" + items[uniqueRandNum[3]].price +"</label>";

  cell5.innerHTML = "<img src=\"" + items[uniqueRandNum[4]].filename + "\" onclick=\"addToCart('c5','d5','p5')\" id = \"c5\"> <br> <label id=\"d5\">"+ items[uniqueRandNum[4]].caption +"</label> $  <label id=\"p5\">" + items[uniqueRandNum[4]].price +"</label>";

  cell6.innerHTML = "<img src=\"" + items[uniqueRandNum[5]].filename + "\" onclick=\"addToCart('c6','d6','p6')\" id = \"c6\"> <br> <label id=\"d6\">"+ items[uniqueRandNum[5]].caption +"</label> $  <label id=\"p6\">" + items[uniqueRandNum[5]].price +"</label>";

// Part 2
let cart = []
let total = 0

const addToCart = (imgId, capId, prId) => {
  cart.push({img: imgId, cap: capId, price: prId})

  let priceElement = document.getElementById(prId)
  console.log(priceElement.innerText)

  let price = Number(document.getElementById(prId).innerText)
  total += price
  renderCart(imgId, capId, prId)
  renderTotal()
}

const renderCart = (imgId, capId, prId) => {

    var im = document.getElementById(imgId);
    var cap = document.getElementById(capId);
    var pr = document.getElementById(prId);

    var row = shopping.insertRow(1);  // row 1 under headers

    var imageCell = row.insertCell(0); // Cell1
    var captionCell = row.insertCell(1); // Caption
    var priceCell = row.insertCell(2); // Price
    var quantCell = row.insertCell(3); // Quantity
    var actCell = row.insertCell(4);

    // Image cell 1
    var image = document.createElement("img");
    image.src = im.src;
    image.width = 50; // Resizes image smaller
    imageCell.appendChild(image);

    // Caption cell 2
    var caption = document.createElement("p");
    caption.innerHTML = cap.innerText;
    captionCell.appendChild(caption);

    // Price cell 3
    var price = document.createElement("p");
    price.innerHTML = pr.innerText;
    priceCell.appendChild(price);
}

const renderTotal = () => {
    // Total
    var row = shopping.insertRow(-1);  // bottom row
    var cell1 = row.insertCell(0);
    cell1.colSpan = 4;
    cell1.innerHTML = "Total";
    var cell2 = row.insertCell(1);
    roundTotal = Math.round(total * 100) /100
    cell2.innerHTML = '$' + roundTotal;
}

// Part 3
  function viewMore(flag){
    let butt = document.getElementById("button");
    if(flag===1){
      butt.onclick = function() {viewMore(0)};
      let j = 1;
      for (var i = 0; i < 12; i++) {
        if (uniqueRandNum.includes(i)) {
          let imgTag = document.getElementById("c".concat(j));
          imgTag.src = items[i].filename;
          let labelTag = document.getElementById("d".concat(j));
          labelTag.innerHTML = items[i].caption;
          let priceTag = document.getElementById("p".concat(j));
          priceTag.innerHTML = items[i].price;

          j++;
        }
      }
    }else{
      butt.onclick = function() {viewMore(1)};
      let j = 1;
      for (var i = 0; i < 12; i++) {
        if (!uniqueRandNum.includes(i)) {
          let imgTag = document.getElementById("c".concat(j));
          imgTag.src = items[i].filename;
          let labelTag = document.getElementById("d".concat(j));
          labelTag.innerHTML = items[i].caption;
          let priceTag = document.getElementById("p".concat(j));
          priceTag.innerHTML = items[i].price;
          j++;
        }
      }
    }
  }
