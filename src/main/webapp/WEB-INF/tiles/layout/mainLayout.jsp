<!DOCTYPE html>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta charset="utf-8">
		<title>Lingvo</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
		<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
		
		<script src="/js/base.js"></script>
		<style>
			.card-header-custom {
				background-color: #018786;
				color: white;
				text-align: center;
			}
	
			.btn-custom {
				background-color: #018786;
				border-color: #018786;
            	color: white;
			}
			.carousel-caption {
				background-color: rgba(0, 0, 0, 0.7);
				padding: 10px;
				color: white;
				text-align: right;
			}
		</style>
	</head>
	<body>
		<main>
			<!-- Header -->
			<tiles:insertAttribute name="header" />
			<!-- Body -->
			<tiles:insertAttribute name="body" />
			<!-- Footer -->
			<tiles:insertAttribute name="footer" />
		</main>
	</body>
</html>