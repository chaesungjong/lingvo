<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<input type="hidden" id="name"        value="${name}">
<input type="hidden" id="siteName"    value="${siteName}">
<input type="hidden" id="constName"   value="${constName}">
<input type="hidden" id="companyName" value="${companyName}">
<input type="hidden" id="workType"    value="${workType}">
<div class="container mt-5">
    <div class="row">
        <div class="col-md-4" name="next" value="N">
            <div class="card mb-4">
                <div class="row g-0">
                    <div class="col-auto">
                        <span class="material-icons">icon1</span>
                    </div>
                    <div class="col">
                        <div class="card-body">
                            <p class="card-text">새로운 작업</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-4" name="next" value="R">
            <div class="card mb-4">
                <div class="row g-0">
                    <div class="col-auto">
                        <span class="material-icons">icon1</span>
                    </div>
                    <div class="col">
                        <div class="card-body">
                            <p class="card-text">어제와 동일한 작업</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-4" name="next" value="S">
            <div class="card mb-4">
                <div class="row g-0">
                    <div class="col-auto">
                        <span class="material-icons">icon1</span>
                    </div>
                    <div class="col">
                        <div class="card-body">
                            <p class="card-text">돌발 작업</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="/js/work/worker/start/workedList.js"></script>


