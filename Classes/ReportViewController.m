//
//  ReportViewController.m
//  Carat
//
//  Created by Adam Oliner on 12/14/11.
//  Copyright (c) 2011 UC Berkeley. All rights reserved.
//

#import "ReportViewController.h"
#import "ReportItemCell.h"
#import "CorePlot-CocoaTouch.h"
#import "Utilities.h"
#import "DetailViewController.h"
#import "FlurryAnalytics.h"

@implementation ReportViewController

@synthesize detailViewName;
@synthesize tableTitle;
@synthesize thisText;
@synthesize thatText;

@synthesize dataTable = _dataTable;

// The designated initializer. Override to perform setup that is required before the view is loaded.
- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil {
	self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
	if (self) {
        // custom code (overridden by subclass)
    }
    return self;
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Release any cached data, images, etc that aren't in use.
}

- (DetailViewController *)getDetailView
{
    return nil;
}

#pragma mark - table methods

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section
{
    if (report != nil && [report hbListIsSet]) {
        return [[report hbList] count];
    } else return 0;
}

- (NSString *)tableView:(UITableView *)tableView titleForHeaderInSection:(NSInteger)section
{
    return self.tableTitle;
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    
    static NSString *CellIdentifier = @"ReportViewCell";
    
    ReportItemCell *cell = [tableView dequeueReusableCellWithIdentifier:CellIdentifier];
    if (cell == nil) {
        NSArray *topLevelObjects = [[NSBundle mainBundle] loadNibNamed:@"ReportItemCell" owner:nil options:nil];
        for (id currentObject in topLevelObjects) {
            if ([currentObject isKindOfClass:[UITableViewCell class]]) {
                cell = (ReportItemCell *)currentObject;
                break;
            }
        }
    }
    
    // Set up the cell...
    NSString *appName = [[[report hbList] objectAtIndex:indexPath.row] pName];
    cell.appName.text = appName;
    
    UIImage *img = [UIImage imageNamed:[appName stringByAppendingString:@".png"]];
    if (img != nil) {
        cell.appIcon.image = img;
    } else {
        cell.appIcon.image = [UIImage imageNamed:@"icon57.png"];
    }

    cell.appScore.progress = [[[report hbList] objectAtIndex:indexPath.row] wDistance];    
    return cell;
}

- (NSString *)tableView:(UITableView *)tableView titleForFooterInSection:(NSInteger)section
{
    NSDate *lastUpdated = [[Sampler instance] getLastReportUpdateTimestamp];
    NSDate *now = [NSDate date];
    NSTimeInterval howLong = [now timeIntervalSinceDate:lastUpdated];
    return [Utilities formatNSTimeIntervalAsNSString:howLong];
}

// loads the selected detail view
- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath {
    ReportItemCell *selectedCell = (ReportItemCell *)[tableView cellForRowAtIndexPath:indexPath];
    [selectedCell setSelected:NO animated:YES];
    
    DetailViewController *dvController = [self getDetailView];
    [self.navigationController pushViewController:dvController animated:YES];
    
    [[dvController appName] makeObjectsPerformSelector:@selector(setText:) withObject:selectedCell.appName.text];

    UIImage *img = [UIImage imageNamed:[selectedCell.appName.text stringByAppendingString:@".png"]];
    if (img != nil) {
        [[dvController appIcon] makeObjectsPerformSelector:@selector(setImage:) withObject:img];
    } else {
        [[dvController appIcon] makeObjectsPerformSelector:@selector(setImage:) withObject:[UIImage imageNamed:@"icon57.png"]];
    }

    for (UIProgressView *pBar in [dvController appScore]) {
        [pBar setProgress:selectedCell.appScore.progress animated:NO];
    }
    
    [[dvController thisText] makeObjectsPerformSelector:@selector(setText:) withObject:self.thisText];
    [[dvController thatText] makeObjectsPerformSelector:@selector(setText:) withObject:self.thatText];
    
    [FlurryAnalytics logEvent:[@"selected" stringByAppendingString:self.detailViewName]
               withParameters:[NSDictionary dictionaryWithObjectsAndKeys:selectedCell.appName.text, @"App Name", nil]];
}

#pragma mark - View lifecycle

- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.

    //Setup the navigation
    self.navigationItem.title = self.tableTitle;
}

- (void)viewWillAppear:(BOOL)animated
{
    [super viewWillAppear:animated];
    
    [self.navigationController setNavigationBarHidden:YES animated:YES];
}

- (void)viewDidAppear:(BOOL)animated
{
    [super viewDidAppear:animated];
}

- (void)viewWillDisappear:(BOOL)animated
{
	[super viewWillDisappear:animated];
    
    [self.navigationController setNavigationBarHidden:NO animated:YES];
}

- (void)viewDidDisappear:(BOOL)animated
{
	[super viewDidDisappear:animated];
}

- (BOOL) shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)orientation {
    return YES;
}

- (void)viewDidUnload
{
    [dataTable release];
    [self setDataTable:nil];
    [super viewDidUnload];
    // Release any retained subviews of the main view.
    // e.g. self.myOutlet = nil;
}

- (void)dealloc {
    [dataTable release];
    [listOfAppNames release];
    [listOfAppScores release];
    [super dealloc];
}

@end