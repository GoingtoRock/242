<?php
	$con = mysqli_connect("localhost","my_user","my_password","my_db");
	if (mysqli_connect_errno()) {
		echo "Failed to connect to MySQL: " . mysqli_connect_error();
	}
?>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>cs242</title>

</head>
<body>
	<div class="input-container">
		<input type="text" id="newUser"><input type="text" id="newComment">
	</div>
	<div id="comment-container">
		<?php
			$result = $con->query("SELECT * FROM comments ORDER BY date_create DESC");

			if ($result) {
				while ($row = $result->fetch_assoc()) {
					echo '<div class="comment">';
					echo "<span>".$row["username"]."</span>";
					echo "<span>".$row["written"]."</span>";
					echo "<div>".$row["content"]."</div>";
					echo '</div>';	
				}
				$result->free();
			}
		?>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script>
		function formatDate(date) {
		    var d = new Date(date),
		        month = '' + (d.getMonth() + 1),
		        day = '' + d.getDate(),
		        year = d.getFullYear();

		    if (month.length < 2) month = '0' + month;
		    if (day.length < 2) day = '0' + day;

		    return [year, month, day].join('-');
		}

		function postNewComment(data) {
			$.ajax({
				url: '/newComment.php',
				cache: false,
				data: data,
				type: 'POST',
				success: function() {
					window.location.reload(true);
				},
				error: function() {
					alert('error posting comment');
				}
			});
		}

		$("#new_comment").keyup(function(e) {
			var $newUser = $("#newUser"),
				$content = $("#newComment");
			
			var data = {
				username: $newUser,
				content: $content,
				written: formatDate(Date.now())
			};
			
			if (e.keyCode === 13) {
				name = $newUser.val();
				content = $content.val();
				$newUser.val('');
				$content.val('');
				postNewComment(data);
			}
		});
	</script>
</body>
</html>
<?php
$con->close();
?>