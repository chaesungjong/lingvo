<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<section class="text-center container">
      <div class="col-lg-6 col-md-8 mx-auto">
        <h1 class="fw-light">사진 첨부</h1>
      </div>
</section>

<div class="album bg-light">
    <div class="container">
      <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
        <div class="col">
          <div class="card shadow-sm">
            <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="https://namu.wiki/jump/7bgDyzN6keqskoFaJaxq%2FZTEXnGPSrtTgv%2FIHzpkIW11YYpokeUrQskOCJTpNpkpp1emLDR7ob8uLCRSyZJ1dw%3D%3D" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>사용자 선택</title><rect width="100%" height="100%" fill="#55595c"></rect></svg>

            <div class="card-body">
              <div class="d-flex justify-content-between align-items-center">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-circle" viewBox="0 0 16 16">
                    <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                    <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
                  </svg>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
    <div class="row">
        <div class="col">
        <button class="btn btn-custom btn-block" id="next">확인</button>
        </div>
    </div>
</div>
<script>
    $("#next").click(function() {
        location.href = "/work/requestPicturePlusDitail";
    });
</script>

