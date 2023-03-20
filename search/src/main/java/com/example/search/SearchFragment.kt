package com.example.search

//class SearchFragment : //BaseFragment() {
//
//    @Inject
//    internal lateinit var overviewViewModelFactory: Lazy<OverviewViewModelFactory>
//
//    private val binding by viewBinding(FragmentOverviewBinding::bind)
//    private val viewModel: OverviewViewModel by viewModels {
//        overviewViewModelFactory.get()
//    }
//
//    override fun onAttach(context: Context) {
//        ViewModelProvider(this).get<OverviewComponentViewModel>()
//            .newOverviewComponent.inject(this)
//        super.onAttach(context)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        setupUI()
//        requestMealList()
//
//        binding.layoutSwipeRefresh.setOnRefreshListener {
//            viewModel.updateMealList()
//        }
//    }
//
//    private fun setupUI() {
//        val adapter = createAdapter()
//        setupRecyclerView(adapter)
//        observeViewStateUpdates(adapter)
//        subscribeToViewEffects()
//    }
//
//    private fun createAdapter(): MealAdapter {
//        return MealAdapter { mealId ->
//            findNavController().navigate(
//            OverviewFragmentDirections
//                .actionFragmentOverviewPageToNavUserDetails(mealId)
//        ) }
//    }
//
//    private fun setupRecyclerView(adapter: MealAdapter) {
//        binding.recyclerView.apply {
//            layoutManager = LinearLayoutManager(
//                context, LinearLayoutManager.VERTICAL, false)
//            setAdapter(adapter)
//            this.addHorizontalSpaceDecoration(Utils.RECYCLER_ITEM_SPACE)
//        }
//    }
//
//    private fun observeViewStateUpdates(adapter: MealAdapter) {
//        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
//            viewModel.viewState.collect { updateUi(it, adapter) }
//        }
//    }
//
//    private fun updateUi(viewState: OverviewFragmentViewState, adapter: MealAdapter) {
//        adapter.submitList(viewState.meals)
//        binding.loadingProgressBar.isVisible = viewState.loading
//        binding.layoutSwipeRefresh.isRefreshing = viewState.loading
//    }
//    private fun subscribeToViewEffects() {
//        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
//            viewModel.viewEffects.collect {
//                when (it) {
//                    is OverviewFragmentViewEffects.Failure -> handleFailure(it.cause)
//                }
//            }
//        }
//    }
//
//    private fun handleFailure(cause: Throwable) {
//        binding.loadingProgressBar.isVisible = false
//
//        val message = when (cause) {
//            is NetworkUnavailable -> getString(R.string.network_unavailable_error_message)
//            else -> getString(R.string.generic_error_message)
//        }
//
//        showSnackbar(message)
//        showLocalData()
//    }
//
//    private fun showLocalData() {
//        viewModel.setLocalData()
//    }
//
//
//    private fun showSnackbar(message: String) {
//        Snackbar.make(requireView(), message, Snackbar.LENGTH_SHORT).show()
//    }
//
//    private fun requestMealList() {
//        viewModel.requestMealList()
//    }
//}

