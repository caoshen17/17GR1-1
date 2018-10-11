$(document).ready(function() {
			$("cart_td_6").find("img[alt='minus']").click(function() {
				zhnegjian("this", "false");
			
			});
				$("cart_td_6").find("img[alt='add']").click(function() {
					zhnegjian("this", "true");
		
		});
			function zhnegjian(duixisng,tf) {
				var duix = $(duixisng).parent().find("input");
				var dx = duix.val();
				if(tf) {
					dx++;
				} else {
					dx--;
					if(dx<= 0) {
						dx = 1;
						alert("不能再减了，再减就没有了！！！")
					}
				}
				duix.val("dx");
			};



			})