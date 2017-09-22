<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
	th:replace="~{fragments/layout :: layout (~{::body},'Account')}">
<head>
<meta charset="utf-8">
<meta name="description" content="アカウント情報を表示します。">
<title>アカウント管理</title>
<link href="css/common.css" rel="stylesheet" />
<link href="css/bootstrap.css" rel="stylesheet" />
<link href="css/jquery.bootgrid.css" rel="stylesheet" />
</head>
<body>
	<script type="text/javascript">

	</script>
	<div class="container">
		<!-- <div class="table-responsive"> -->
		<table class="table table-bordered">
			<thead>
				<tr>
					<th data-column-id='no' data-type='numeric' data-identifier='true'
						data-width='3%'>No</th>
					<th data-column-id='custid' data-width='7%'>ユーザーID</th>
					<th data-column-id='username' data-width='10%'>ユーザー名</th>
					<th data-column-id='orgname' data-width='40%'>所属</th>
					<th data-column-id='role' data-width='40%'>権限</th>
				</tr>
			<tbody>

			</tbody>
		</table>
		<!-- </div> -->
	</div>
</body>
</html>
