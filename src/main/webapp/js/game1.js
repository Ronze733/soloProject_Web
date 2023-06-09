/**
 * 
 */



let canvas = document.getElementById("canvas");
let ctx = canvas.getContext("2d");

canvas.width = 600;
canvas.height = 600;

let point = {
	x: 100,
	y: 50,
	draw(t){
		ctx.textAlign = "center";
		ctx.textBaseline = "middle";
		ctx.fillText("점수 : " + t, this.x, this.y)
	}
}

let dino = {
	x: 10,
	y: 200,
	width: 50,
	height: 50,
	draw() {
		ctx.fillStyle = 'green';
		ctx.fillRect(this.x, this.y, this.width, this.height)
	}
}

let img1 = new Image();
img1.src = "./gameImgs/ramen.jpg";

class Cactus {
	constructor() {
		this.x = 500;
		this.y = 200;
		this.width = 50;
		this.height = 50;
	}
	draw() {
		ctx.fillStyle = 'red';
		/*ctx.fillRect(this.x, this.y, this.width, this.height);*/
		ctx.drawImage(img1, this.x, this.y, this.width, this.height);
	}
}
let cactus = new Cactus();
cactus.draw();

let timer = 0;

let cactuss = [];

let jump = false;
let jumptimer = 0;
let animation;
let t = 0;

function doPerFrame() {
	animation = requestAnimationFrame(doPerFrame)
	timer++;
	if(timer % 60 == 0)
		t++;
	ctx.clearRect(0, 0, canvas.width, canvas.height);
	
	point.draw(t);

	if (timer % 200 === 0) {
		let cactus = new Cactus();
		cactuss.push(cactus);
	}

	cactuss.forEach((a, i, o) => {
		if (a.x < -50) {
			o.splice(i, 1);
		}
		a.x--;
		
		collisionCheck(dino, a);
		
		a.draw();
	});

	if (jump) {
		if (jumptimer < 80) {
			jumptimer++;
			dino.y -= 3;
		} else {
			if(dino.y < 200)
				dino.y += 3;
			else{
				dino.y = 200;
				jump = false;
				jumptimer = 0;
			}
		}
	}
	
	dino.draw();
}

doPerFrame();

document.addEventListener('keydown', function(e){
	if(e.code === 'Space' && animation == null){
		doPerFrame();
	}
})


// 충돌 확인 코드
function collisionCheck(dino, cactus){
	let x_dino = dino.x + 50;
	let y_dino = dino.y + 50;
	let x_cactus = cactus.x;
	let y_cactus = cactus.y;
	
	if((x_cactus - x_dino) < 0 && (y_cactus - y_dino) < 0 && (cactus.x + 50  - dino.x) > 0){
		ctx.clearRect(0, 0, canvas.width, canvas.height);
		cancelAnimationFrame(animation);
		animation = null;
		cactuss = [];
		timer = 0;
		t = 0;
		dino.y = 200;
	}
}



document.addEventListener('keydown', function(e) {
	if (e.code === 'Space' && dino.y === 200 && !jump && timer >= 1) {
		jump = true;
	}
});

















