$(function(){
			/* jqueryの動作確認 */
			$("#fetchGreeting").click(function(){
                $.get("/hello", function(data){
                    $("#greeting").text(data);
                });
            });
			
			/* closesetの挙動を確認する */
			// closestはターゲット要素の一番近い祖先要素を返す
			var targetElement = $("#target"); //ターゲットの要素を取得する
			var closestAncestor = targetElement.closest(".ancestor"); //近くのancestor要素を取得する
			if (closestAncestor.length > 0) {
			    console.log("Closest ancestor found:", closestAncestor);
				
				/*addclass*/
				targetElement.addClass("highlight"); // クラスを追加
			} else {
			    console.log("No closest ancestor found");
			}
			
			/* removeclass 対象ターゲットを削除する */
			var deleteElement = $("#deltarget");
			$("#deleteButton").click(function(){
				deleteElement.removeClass('highlight');
			});
			
			
			/* cssプロパティを変更 */
			var changeElement = $("#changeTarget")
			var parentElement = changeElement.closest(".ancestor");
			var changeBtn = $("#changeButton")
			if(parentElement.length > 0){
				changeBtn.click(function(){
					parentElement.css({
						//追加されるcsv
						"background-color": "yellow",
	                    "border-color" : "red"
					})
				});	
			}
			
			/* 要素を表示と非表示 */
			var toggleElement = $("#toggleTarget");
			var toggleAncester =  toggleElement.closest(".ancestor");
			var toggleOnBtn = $("#toggleOnButton");
			var toggleOffBtn = $("#toggleOffButton");
			toggleOnBtn.click(function(){
				toggleAncester.toggle(true);
						});
			toggleOffBtn.click(function(){
				toggleAncester.toggle(false);
			});
			
			/* 数秒遅延させてformを送信する */			
			var playBtn = $("#playButton");
			var playAncestor = playBtn.closest(".ancestor");
			playBtn.click(function(){
				playAncestor.delay(5000).queue(function(next) {
					console.log("Delayed action executed");
					document.play.submit();	
					next();
				});
        	});
		});