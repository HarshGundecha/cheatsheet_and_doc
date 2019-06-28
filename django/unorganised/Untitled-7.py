from django.views.generic import ListView
from books.models import Publisher

ModelList(ListView):
	model = <Model> #compulsory
	# by default looks for template
	# 	named '<model>_list.html'.
	# 	to override define `template_name` as below
	template_name = '<app_name>/<template_name>.html'
	
	# by default exposes 'object_list' and also '<model>_list'
	# 	named variable that holds list of object.
	# 	to override define `context_object_name` as below
	context_object_name = <some_name>

	# by default the list of all objects of `model` will be fetched
	#		to override define `queryset` or `get_queryset()` as below
	queryset = <query_expression_to_fetch_objects>
	# OR for more complex logic
	def get_queryset(self, **kwargs):
		return <model_objects>

ModelDetail(DetailView):
	model = <Model> #compulsory
	# by default looks for template
	# 	named '<model>_detail.html'.
	# 	to override define `template_name` as below
	template_name = '<app_name>/<template_name>.html'
	
	# by default exposes 'object' and also '<model>'
	# 	named variable that holds detail of object.
	# 	to override define `context_object_name` as below
	context_object_name = <some_name>

	# by default the detail of object of `model` will be fetched.
	# 	to override define `queryset` or `get_queryset()` or `get_object()` as below
	queryset = <query_expression_to_fetch_objects>
	# OR for more complex logic
	def get_context_data(self, **kwargs):
		return <model_objects>
	# OR
	def get_object(self, **kwargs):
		return <model_objects>
	# deicde which is best to use upob requirements

