# BlueHorn

fix sequences:
@SequenceGenerator(name="BHPOST_POSTID_GENERATOR", sequenceName="BHPOST_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="BHPOST_POSTID_GENERATOR")
	
