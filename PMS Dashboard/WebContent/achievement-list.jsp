<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Project Management System Dashboard</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<script src="//www.amcharts.com/lib/4/core.js"></script>
<script src="//www.amcharts.com/lib/4/charts.js"></script>
<script src="//www.amcharts.com/lib/4/maps.js"></script>

< script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" ></script>

<script>
	am4core.ready(function() {
		let chart = am4core.createFromConfig({
			"type" : "XYChart",
			"data" : [ {
				"category" : "January",
				"achievement" : 27.77
			}, {
				"category" : "February",
				"achievement" : 12.76
			}, {
				"category" : "March",
				"achievement" : 44
			}, {
				"category" : "April",
				"achievement" : 56.56
			}, {
				"category" : "May",
				"achievement" : 29.9
			}, {
				"category" : "June",
				"achievement" : 31.1
			}, {
				"category" : "July",
				"achievement" : 45.55
			}, {
				"category" : "August",
				"achievement" : 79.89
			}, {
				"category" : "September",
				"achievement" : 98.89
			}, {
				"category" : "October",
				"achievement" : 56.56
			}, {
				"category" : "November",
				"achievement" : 73.32
			}, {
				"category" : "December",
				"achievement" : 99
			} ],
			"xAxes" : [ {
				"type" : "CategoryAxis",
				"dataFields" : {
					"category" : "category"
				},
				"renderer" : {
					"grid" : {
						"template" : {
							"type" : "Grid",
							"visible" : false,
							"location" : 0
						}
					},
					"minGridDistance" : 20
				}
			} ],
			"yAxes" : [ {
				"type" : "ValueAxis",
				"title" : {
					"type" : "Label",
					"text" : "Achievement"
				},
				"min" : 0,
				"max" : 110,
				"renderer" : {
					"grid" : {
						"template" : {
							"type" : "Grid"
						}
					},
					"line" : {
						"type" : "AxisLine",
						"stroke" : "#cfcfd6",
						"strokeWidth" : 1,
						"strokeOpacity" : 1
					},
					"maxLabelPosition" : 0.98
				}
			} ],
			"series" : [ {
				"type" : "ColumnSeries",
				"name" : "Achievement",
				"columns" : {
					"template" : {
						"type" : "Column",
						"strokeOpacity" : 0,
						"tooltipText" : "{categoryX}\n{valueY}",
						"tooltipPosition" : "pointer"
					}
				},
				"bullets" : {
					"values" : [ {
						"type" : "LabelBullet",
						"visible" : true,
						"label" : {
							"type" : "Label",
							"text" : "{valueY}%",
							"paddingTop" : -20
						},
						"locationY" : 0,
						"locationX" : 0.5
					} ],
					"template" : {
						"type" : "Bullet"
					}
				},
				"dataFields" : {
					"valueY" : "achievement",
					"categoryX" : "category"
				},
				"fill" : "#67b7dc",
				"stroke" : "#67b7dc",
				"sequencedInterpolation" : true,
				"sequencedInterpolationDelay" : 100
			} ],
			"legend" : {
				"type" : "Legend"
			},
			"scrollbarX" : {
				"type" : "Scrollbar"
			},
			"maskBullets" : false
		}, document.getElementById('chartdiv'));
	});
</script>

</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #17499c">
			<div>
				<a href="http://live.revesoft.com/pms/" class="navbar-brand">
					Project Management System Dashboard </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="#" class="nav-link">Achievements</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="container" style="border: 1px ridge #b0b2ba;">
		<form>
			<div class="row mb-2 mt-2">

 <div class="col-lg-6  mb-lg-0 mb-6">
				 <select class="form-select" aria-label="Default select example">
					<option selected>Select Year</option>
					<option value="1">2020</option>
					<option value="2">2019</option>
					<option value="3">2018</option>
					<option value="4">2017</option>
					<option value="5">2016</option>
					<option value="5">2015</option>
					<option value="5">2014</option>
					<option value="5">2013</option>
					<option value="5">2012</option>
					<option value="5">2011</option>
					<option value="5">2010</option>
				</select> 
				

			</div> 
			

			</div>
			
		</form>

	</div>


	<div class="container"
		style="border: 1px ridge #b0b2ba; margin-top: 20px">
		<div class="card card-custom gutter-b">
			<div class="card-header">
				<div class="card-title">
					<h3 class="card-label">
						Basic Card <small>sub title</small>
					</h3>
				</div>
			</div>
			<div class="card-body">

				<div id="chartdiv" style="width: 100%; height: 500px;"></div>

			</div>
		</div>

	</div>


	<div class="container"
		style="border: 1px ridge #b0b2ba; margin-top: 20px; padding-top: 10px">


		<table class="table table-bordered">
			<thead>
				<tr>
					<th>User ID</th>
					<th>Year</th>
					<th>Month</th>
					<th>Achievement</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="achievement_object" items="${listAchievement}">

					<tr>
						<td><c:out value="${achievement_object.userId}" /></td>
						<td><c:out value="${achievement_object.year}" /></td>
						<td><c:out value="${achievement_object.month}" /></td>
						<td><c:out value="${achievement_object.achievement}" /></td>
					</tr>
				</c:forEach>
				<!-- } -->
			</tbody>

		</table>

	</div>
	


</body>
</html>