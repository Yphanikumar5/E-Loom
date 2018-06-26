<!DOCTYPE html>
<html lang="en">

	<head>

		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="">
		<meta name="author" content="">

		<title>Phani-home</title>

		<!-- Bootstrap Core CSS -->
		<link href="css/bootstrap.min.css" rel="stylesheet">

		<!-- Custom CSS -->
		<link href="css/main.css" rel="stylesheet">


	</head>

	<body>

		<div id="wrapper">
			<!-- Navigation -->
			<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<span class="pull-left lang_conv">
					<a href="?lang=EN">
					<button class="btn btn-warning">
						English
					</button>
					</a>
					<a href="?lang=TE">
					<button class="btn btn-success">
						&#3108;&#3142;&#3122;&#3137;&#3095;&#3137;
						<br />
					</button> </a></span>
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>

				<a class="navbar-brand mob_logo" href=""> <span> <b
						style="font-weight: bold; font-size: 30px; color: red">E</b> <b
						style="font-weight: bold; font-size: 30px; color: #000">Loom Management</b> <span>
				</a>
			</div>
			<!-- Top Menu Items -->
			<ul class="nav navbar-right top-nav hide-on-mobile">
				<li>
					<a class="page-scroll" href="adminhome.htm">Home&nbsp;&nbsp;&nbsp;<font
						color="white">|</font> </a>

				</li>
				<li>
				<li>
					<a class="page-scroll" href="#">About Us&nbsp;&nbsp;&nbsp;<font
						color="white">|</font> </a>
				</li>
				<li>
					<a class="page-scroll" href="#">Site Map&nbsp;&nbsp;&nbsp;<font
						color="white">|</font> </a>
				</li>
				<li>
					<a class="page-scroll" href="#" style="border: none;">Contact</a>
				</li>
				<!--  
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> Home <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a class="page-scroll" href="#">About Us</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="page-scroll" href="#">Site Map</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="page-scroll" href="#" style="border:none;">Contact</a>
                        </li>
                    </ul>
                </li>
                -->
			</ul>

			<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->

			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav side-nav"
					style="height: 450px; background-color: #C1C1C1; padding-top: 40px; margin-top: 80px;">
					<li class="active">
						<a href="adminhome.htm"><i class="fa fa-fw fa-dashboard"></i>
							Home</a>
					</li>

					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i
							class="fa fa-fw fa-bar-chart-o"></i> Employees</a>
						<ul class="dropdown-menu">
							<li>
								<a href="showaddemp.htm"><i class="fa fa-fw fa-bar-chart-o"></i>
									Create New Employee</a>
							</li>
							<li>
								<a href="emps.htm"><i class="fa fa-fw fa-bar-chart-o"></i>
									Employees</a>
							</li>
							<li>
								<a href="showaddadvance.htm"><i
									class="fa fa-fw fa-bar-chart-o"></i> Employee Payments</a>
							</li>
							<li>
								<a href="advancess.htm"><i class="fa fa-fw fa-bar-chart-o"></i>
									Advances</a>
							</li>
							
							

						</ul>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i
							class="fa fa-fw fa-bar-chart-o"></i> Customers</a>
						<ul class="dropdown-menu">
							<li>
								<a href="customers.htm"><i class="fa fa-fw fa-bar-chart-o"></i>Customers</a>
							</li>
						
							<li>
								<a href="showaddbill.htm"><i class="fa fa-fw fa-bar-chart-o"></i>
									Pay Bills</a>
							</li>
						</ul>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i
							class="fa fa-fw fa-bar-chart-o"></i> Looom</a>
						<ul class="dropdown-menu">
							<li>
								<a href="showaddloom.htm"><i class="fa fa-fw fa-bar-chart-o"></i>
									Create New Loom</a>
							</li>
							<li>
								<a href="looms.htm"><i class="fa fa-fw fa-bar-chart-o"></i>
									Looms</a>
							</li>

							
						</ul>
					</li>

					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i
							class="fa fa-fw fa-bar-chart-o"></i> Looom Employee</a>
						<ul class="dropdown-menu">
							<li>
								<a href="showallotloom.htm"><i
									class="fa fa-fw fa-bar-chart-o"></i> Allot Loom to Employee</a>
							</li>
							<li>
								<a href="allotedlooms.htm"><i
									class="fa fa-fw fa-bar-chart-o"></i> Alloted Looms</a>
							</li>


						</ul>
					</li>

					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i
							class="fa fa-fw fa-bar-chart-o"></i> Raw</a>
						<ul class="dropdown-menu">
							<li>
								<a href="showaddraw.htm"><i class="fa fa-fw fa-bar-chart-o"></i>
									Add New Raw</a>
							</li>
							<li>
								<a href="raws.htm"><i class="fa fa-fw fa-bar-chart-o"></i>
									Raws</a>
							</li>
						
						</ul>
					</li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i
							class="fa fa-fw fa-bar-chart-o"></i>Allot Raw</a>
						<ul class="dropdown-menu">
							<li>
								<a href="showallotraw.htm"><i
									class="fa fa-fw fa-bar-chart-o"></i> Allot Raw to Loom</a>
							</li>
							<li>
								<a href="allotedraws.htm"><i class="fa fa-fw fa-bar-chart-o"></i>
									Alloted Raws</a>
							</li>


						</ul>
				</li>
				
				
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i
						class="fa fa-fw fa-bar-chart-o"></i> Products</a>
					<ul class="dropdown-menu">
						<li>
							<a href="showaddproduct.htm"><i
								class="fa fa-fw fa-bar-chart-o"></i> Add New Product</a>
						</li>
						<li>
							<a href="products.htm"><i class="fa fa-fw fa-bar-chart-o"></i>
								Products</a>
						</li>


					</ul>
				</li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i
						class="fa fa-fw fa-bar-chart-o"></i> Sales</a>
					<ul class="dropdown-menu">
						<li>
							<a href="showaddbill.htm"><i class="fa fa-fw fa-bar-chart-o"></i>
								Add New Sale</a>
						</li>
						<li>
							<a href="showbill.htm"><i class="fa fa-fw fa-bar-chart-o"></i>
								Sales and Payments:Get Bill</a>
						</li>
						


					</ul>
				</li>





				<li>
					<a href="signout.htm"><i class="fa fa-fw fa-desktop"></i>Signout</a>
				</li>

				</ul>
			</div>

			<!-- /.navbar-collapse -->
			</nav>


			<div id="page-wrapper">
				<div class="container-fluid main-div">