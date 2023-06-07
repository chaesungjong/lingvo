<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />

<style>
#navbar {
  overflow: hidden;
  background-color: #018786;
  border-color: #018786;
  color: white;
}
#navbar a {
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px;
  text-decoration: none;
}
.content {
  padding: 16px;
}
.sticky {
  position: fixed;
  top: 0;
  width: 100%;
}
.sticky + .content {
  padding-top: 60px;
}
.material-symbols-outlined {
  font-variation-settings:
  'FILL' 0,
  'wght' 400,
  'GRAD' 0,
  'opsz' 48
}
.material-symbols-outlined {
  font-variation-settings:
  'FILL' 0,
  'wght' 400,
  'GRAD' 0,
  'opsz' 48
}
</style>
</style>


<nav id="navbar" class="navbar fixed-bottom navbar-expand-sm navbar-dark">
  <a href="/work/main" class="nav-link active py-3 rounded-0" aria-current="page" data-bs-toggle="tooltip" data-bs-placement="right" aria-label="Home" data-bs-original-title="Home"><span class="material-symbols-outlined">home</span></a>
  <a href="javascript:void(0);" onclick="CustomAlert();" class="nav-link active py-3 rounded-0" aria-current="page" data-bs-toggle="tooltip" data-bs-placement="right" aria-label="Home" data-bs-original-title="Home"><span class="material-symbols-outlined">contact_page</span></a>
  <a href="javascript:void(0);" onclick="CustomAlert();" class="nav-link active py-3 rounded-0" aria-current="page" data-bs-toggle="tooltip" data-bs-placement="right" aria-label="Home" data-bs-original-title="Home"><span class="material-symbols-outlined">photo_camera</span></a>
  <a href="javascript:void(0);" onclick="CustomAlert();" class="nav-link active py-3 rounded-0" aria-current="page" data-bs-toggle="tooltip" data-bs-placement="right" aria-label="Home" data-bs-original-title="Home"><span class="material-symbols-outlined">warning</span></a>
</nav>